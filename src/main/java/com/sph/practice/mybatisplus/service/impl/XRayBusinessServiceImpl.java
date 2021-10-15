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

        // 记录不合法的ID列表
        List<Long> unqualifiedIdList = Lists.newArrayList();
        // 丢包总数
        int loseTotal = 0;

        // key列表
        List<Long> idList = Lists.newArrayList(newMap.keySet());
        // 获取到Map的key，然后做比较
        for (int i = 0; i < newMap.size() - 1; i++) {
            Long front = idList.get(i);
            Long back = idList.get(i + 1);
            if (NumberUtil.compare(front + 1, back) != 0) {
                // 若不相等的话，需要看看相减的值是多少，也即为丢包数量
                unqualifiedIdList.add(front);
                loseTotal += NumberUtil.sub(back, front).intValue() - 1;
            }
        }
        System.out.println("打印不连贯的事件ID：");
        for (Long unqualifiedId : unqualifiedIdList) {
            System.out.println(newMap.get(unqualifiedId).getEventId());
        }
        System.out.println("丢包数量：" + loseTotal);

        // 上面已记录了不合法的ID列表，通过Map取出事件ID列表，然后开始POI导出
        // List<String> unqualifiedEventIdList = unqualifiedIdList.stream().map(unqualifiedId -> boMap.get(unqualifiedId).getEventId()).collect(Collectors.toList());
    }

}
