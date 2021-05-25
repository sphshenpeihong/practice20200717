package com.sph.practice.test.mapstruct.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sph.practice.test.mapstruct.convert.UserConvert;
import com.sph.practice.test.mapstruct.pojo.bo.MapStructBO;
import com.sph.practice.test.mapstruct.pojo.bo.MapStructSonBO;
import com.sph.practice.test.mapstruct.pojo.bo.Source1BO;
import com.sph.practice.test.mapstruct.pojo.dto.MapStructDTO;
import com.sph.practice.test.mapstruct.pojo.dto.MapStructSonDTO;
import com.sph.practice.test.mapstruct.pojo.dto.Source1DTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习MapStruct转换实体工具类
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
public class MapStructTest {

    /**
     *
     */
    @Test
    public void test3(){
        // 初始化子数据
        MapStructSonDTO mapStructSonDTO1 = new MapStructSonDTO(1, "test1");
        MapStructSonDTO mapStructSonDTO2 = new MapStructSonDTO(2, "test2");
        MapStructSonDTO mapStructSonDTO3 = new MapStructSonDTO(3, "test3");
        List<MapStructSonDTO> sonDTOList = Lists.newArrayList(mapStructSonDTO2, mapStructSonDTO3);

        // 初始化一条DTO数据
        MapStructDTO mapStructDTO = new MapStructDTO();
        mapStructDTO.setId(1);
        mapStructDTO.setUsername("username111");
        mapStructDTO.setPassword("password111");
        mapStructDTO.setSon(mapStructSonDTO1);
        mapStructDTO.setSons(sonDTOList);

        // 开始由DTO转成BO类型
        MapStructBO mapStructBO = UserConvert.mapper.toMapStructBO(mapStructDTO);
        // 打印
        System.out.println("mapStructDTO" + "：" + mapStructDTO);
        System.out.println("mapStructBO" + "：" + mapStructBO);
    }

    /**
     *
     */
    @Test
    public void test2(){
        MapStructSonBO mapStructSonBO = new MapStructSonBO();
        mapStructSonBO.setId(123);
        mapStructSonBO.setTest("testyixia");

        Source1DTO source1DTO = new Source1DTO();
        source1DTO.setId(1);
        // source1DTO.setSon(JSON.toJSONString(mapStructSonBO));
        source1DTO.setSon(null);


        // 开始由DTO转成BO类型
        Source1BO mapStructBO = UserConvert.mapper.toSource1BO(source1DTO);

        System.out.println(mapStructBO);
    }

}
