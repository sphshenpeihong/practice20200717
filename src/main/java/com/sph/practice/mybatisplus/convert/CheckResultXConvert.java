package com.sph.practice.mybatisplus.convert;

import com.sph.practice.mybatisplus.pojo.bo.XRayLeakagePackageBO;
import com.sph.practice.mybatisplus.pojo.po.CheckResultX;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Mapper
public interface CheckResultXConvert {

    CheckResultXConvert MAPPER = Mappers.getMapper(CheckResultXConvert.class);

    /**
     * X光机记录
     *
     * @param checkResultXPO X光机数据PO持久化对象
     * @return 返参
     * @author Shen Peihong
     */
    List<XRayLeakagePackageBO> toXRayLeakagePackageBOList(List<CheckResultX> checkResultXPO);

}
