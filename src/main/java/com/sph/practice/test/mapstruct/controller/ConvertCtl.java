package com.sph.practice.test.mapstruct.controller;

import com.alibaba.fastjson.JSON;
import com.sph.practice.test.mapstruct.convert.UserConvert;
import com.sph.practice.test.mapstruct.pojo.bo.MapStructSonBO;
import com.sph.practice.test.mapstruct.pojo.bo.Source1BO;
import com.sph.practice.test.mapstruct.pojo.dto.Source1DTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@RestController
@RequestMapping("/convert")
public class ConvertCtl {

    @RequestMapping("/test1")
    public Object test1() {
        MapStructSonBO mapStructSonBO = new MapStructSonBO();
        mapStructSonBO.setId(123);
        mapStructSonBO.setTest("testyixia");

        Source1DTO source1DTO = new Source1DTO();
        source1DTO.setId(1);
        source1DTO.setSon(JSON.toJSONString(mapStructSonBO));
        //source1DTO.setSon(null);


        // 开始由DTO转成BO类型
        Source1BO mapStructBO = UserConvert.mapper.toSource1BO(source1DTO);

        System.out.println(mapStructBO);


        return null;
    }

}
