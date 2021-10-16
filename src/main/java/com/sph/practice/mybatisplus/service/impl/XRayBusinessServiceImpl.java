package com.sph.practice.mybatisplus.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.sph.practice.mybatisplus.convert.CheckResultXConvert;
import com.sph.practice.mybatisplus.mapper.CheckResultXMapper;
import com.sph.practice.mybatisplus.pojo.bo.XRayLeakagePackageBO;
import com.sph.practice.mybatisplus.pojo.dto.LeakagePackageDTO;
import com.sph.practice.mybatisplus.pojo.po.CheckResultX;
import com.sph.practice.mybatisplus.service.XRayBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        System.out.println("总丢包数量为：" + loseTotal);

    }

}
