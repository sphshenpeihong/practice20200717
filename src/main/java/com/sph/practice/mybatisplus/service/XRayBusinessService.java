package com.sph.practice.mybatisplus.service;

import com.sph.practice.mybatisplus.pojo.bo.XRayLeakagePackageBO;
import com.sph.practice.mybatisplus.pojo.dto.LeakagePackageDTO;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public interface XRayBusinessService {

    /**
     * 通过条件获取到X光机的数据
     *
     * @param dto 入参条件
     * @return X光机数据
     * @author Shen Peihong
     * @since 2021-10-15
     */
    List<XRayLeakagePackageBO> getLeakagePackageList(LeakagePackageDTO dto);

    /**
     * 处理X光机漏包数据并导出excel
     *
     * @param boList 入参
     * @author Shen Peihong
     * @since 2021-10-15
     */
    void handleXRayLeakagePackage(List<XRayLeakagePackageBO> boList);

}
