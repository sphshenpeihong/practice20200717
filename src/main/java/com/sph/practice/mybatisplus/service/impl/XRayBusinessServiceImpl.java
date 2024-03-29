package com.sph.practice.mybatisplus.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.sph.practice.mybatisplus.convert.CheckResultXConvert;
import com.sph.practice.mybatisplus.mapper.CheckResultXMapper;
import com.sph.practice.mybatisplus.pojo.bo.XRayLeakagePackageBO;
import com.sph.practice.mybatisplus.pojo.constants.CheckResultXConstant;
import com.sph.practice.mybatisplus.pojo.dto.LeakagePackageDTO;
import com.sph.practice.mybatisplus.pojo.po.CheckResultX;
import com.sph.practice.mybatisplus.pojo.vo.CheckResultStatisticsVO;
import com.sph.practice.mybatisplus.service.XRayBusinessService;
import com.sph.practice.mybatisplus.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Service("xRayBusinessService")
public class XRayBusinessServiceImpl implements XRayBusinessService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    CheckResultXMapper checkResultXMapper;

    @Override
    public List<XRayLeakagePackageBO> getLeakagePackageList(LeakagePackageDTO dto) {
        // 构造查询条件，查询数据
        QueryWrapper<CheckResultX> wrapper = new QueryWrapper<>();
        wrapper.eq("device_id", dto.getDeviceId());
        wrapper.gt("msg_send_time", dto.getStartTime());
        wrapper.lt("msg_send_time", dto.getEndTime());
        wrapper.likeRight("event_id", "XATX_");
        wrapper.orderByAsc("msg_send_time");
        List<CheckResultX> checkResultXPOList = checkResultXMapper.selectList(wrapper);

        return CheckResultXConvert.MAPPER.toXRayLeakagePackageBOList(checkResultXPOList);
    }

    @Override
    public void handleXRayLeakagePackage(List<XRayLeakagePackageBO> boList) {
        // 业务数据根据事件ID去重
        List<XRayLeakagePackageBO> distinctBOList = boList.stream()
                                                          .collect(Collectors.collectingAndThen(Collectors.toCollection(
                                                                  () -> new TreeSet<>(Comparator.comparing(XRayLeakagePackageBO::getEventId))), ArrayList::new));

        // key：截取事件ID后8位
        // value：BO业务对象
        Map<Long, XRayLeakagePackageBO> boMap = distinctBOList.stream()
                                                              .collect(Collectors.toMap(bo -> Long.valueOf(bo.getEventId().substring(bo.getEventId().length() - 8)), e -> e, (v1, v2) -> v2));

        // 按key进行升序排序
        List<Long> keyList = boMap.keySet().stream().sorted(Comparator.comparingInt(Long::intValue)).collect(Collectors.toList());

        Map<Long, XRayLeakagePackageBO> newMap = new LinkedHashMap<>();
        for (Long key : keyList) {
            newMap.put(key, boMap.get(key));
        }

        // 丢包总数
        int loseTotal = 0;

        // key列表
        List<Long> idList = Lists.newArrayList(newMap.keySet());
        // 记录合法ID，以及不合法ID列表（即为漏包ID）
        HashMap<Long, List<Long>> recordMap = new LinkedHashMap<>();

        for (int i = 0; i < newMap.size() - 1; i++) {
            Long front = idList.get(i);
            Long back = idList.get(i + 1);
            if (NumberUtil.compare(front + 1, back) != 0) {
                long differValue = back - front;
                List<Long> unQualifiedIdList = Lists.newArrayList();
                for (long j = 1; j < differValue; j++) {
                    unQualifiedIdList.add(front + j);
                }
                /**
                 * key：合法ID
                 * value：不合法ID列表（都紧跟在合法ID后面的丢包事件ID(简化版，截取后8位)）
                 */
                recordMap.put(front, unQualifiedIdList);
                loseTotal += NumberUtil.sub(back, front).intValue() - 1;
            }
        }

        // 打印信息到控制台
        for (Map.Entry<Long, List<Long>> entry : recordMap.entrySet()) {
            System.out.println("合法事件ID为：\n" + newMap.get(entry.getKey()).getEventId());
            System.out.println("不合法ID为：");
            entry.getValue().forEach(System.out::println);
            System.out.println("丢了：" + entry.getValue().size() + " 个包");
            System.out.println("***************\n");
        }

        System.out.println("丢包事件ID列表打印：\n");
        recordMap.values().stream().flatMap(Collection::stream).forEach(System.out::println);

        System.out.println("总丢包数量为：" + loseTotal);

    }

    @Override
    public CheckResultStatisticsVO checkResultXStatistics(String dayTime) {
        CheckResultStatisticsVO vo = new CheckResultStatisticsVO();

        QueryWrapper<CheckResultX> wrapper = new QueryWrapper<>();
        if (StringUtils.isBlank(dayTime)) {
            // 查当天
            wrapper.likeRight("msg_send_time", DateUtils.toStringOfLocalDate(LocalDate.now(), "yyyy-MM-dd"));

        } else {
            // 查指定时间
            wrapper.likeRight("msg_send_time", dayTime);
        }
        List<CheckResultX> checkResultXList = checkResultXMapper.selectList(wrapper);
        // 过包总数
        int passPack = checkResultXList.size();
        Map<Integer, List<CheckResultX>> resultMap = checkResultXList.stream().collect(Collectors.groupingBy(CheckResultX::getWarning));
        // 开包检查
        List<CheckResultX> unpack = resultMap.getOrDefault(CheckResultXConstant.TYLE_UNPACK, Collections.singletonList(new CheckResultX()));
        // 正常放行
        List<CheckResultX> pass = resultMap.getOrDefault(CheckResultXConstant.TYPE_PASS, Collections.singletonList(new CheckResultX()));
        // 判图超时
        List<CheckResultX> judgementOvertime = resultMap.getOrDefault(CheckResultXConstant.TYPE_JUDGEMENT_OVERTIME, Collections.singletonList(new CheckResultX()));
        // 调度超时
        List<CheckResultX> dispatcherOvertime = resultMap.getOrDefault(CheckResultXConstant.TYPE_DISPATCHER_OVERTIME, Collections.singletonList(new CheckResultX()));
        // 已处理开包数
        long handledUnpack = checkResultXList.stream().filter(e -> e.getStatus() == 1).count();
        // 平均分配调度时长
        BigDecimal dispatcherTime = new BigDecimal("0.00");
        // 累加（包裹接收时间与包裹分发时间之间的差值）
        for (CheckResultX checkResultX : checkResultXList) {
            long differValue = DateUtil.between(checkResultX.getDispatchTime(), checkResultX.getReceiveTime(), DateUnit.MS);
            dispatcherTime = dispatcherTime.add(new BigDecimal(differValue));
        }
        // 计算平均分配调度时长
        float avgDispatcherTime = dispatcherTime.divide(new BigDecimal(1000)).divide(new BigDecimal(passPack), 2, BigDecimal.ROUND_HALF_UP).floatValue();

        // 判图员数量
        vo.setJudgementPerson(selectJudgemtnNum());
        // 过包总数
        vo.setPassPack(passPack);
        // 已完成判图数
        vo.setCompleteJudgement(unpack.size() + pass.size());
        // 开包总数
        vo.setUnpack(unpack.size() + judgementOvertime.size() + dispatcherOvertime.size());
        // 分配失败
        vo.setDispatcherError(dispatcherOvertime.size());
        // 超时处理
        vo.setOvertimeHandle(judgementOvertime.size());
        // 已处理开包数
        vo.setHandledUnpack(((Number) handledUnpack).intValue());
        // 平均分配调度时长
        vo.setAvgDispatcherTime(avgDispatcherTime);

        return vo;
    }

    /**
     * 查询判图员数量
     *
     * @return 返参
     */
    private Integer selectJudgemtnNum() {
        //判图员数量
        Set<String> seatKeys = redisTemplate.keys("Executor.Online#*");
        int size = 0;
        if (seatKeys != null) {
            size = Objects.requireNonNull(redisTemplate.opsForValue()
                                                       .multiGet(seatKeys))
                          .stream()
                          .map(Integer.class::cast)
                          .reduce(Integer::sum)
                          .orElse(0);
        }

        return size;
    }

}
