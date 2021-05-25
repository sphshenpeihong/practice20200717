package com.sph.practice.component.boot.controller;

import com.sph.practice.component.boot.pojo.vo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2021/2/23
 * Description: Controller测试类 (yml配置文件各种格式详解)
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/car")
public class CarCtl {

    @Resource
    private Car car;

    @Resource
    private CarNameArray carNameArray;

    @Resource
    private CarNameList carNameList;

    @Resource
    private CarList carList;

    @Resource
    private CarMap carMap;

    @Resource
    private ClassNestClass classNestClass;

    @Resource
    private MapperPath mapperPath;

    /**
     * # 自定义配置项1  对象数据
     *
     * @return
     */
    @RequestMapping("/test1.do")
    public Car test1(){
        return car;
    }

    /**
     * # 自定义配置项2  数组数据 (String类型)
     *
     * @return
     */
    @RequestMapping("/test2.do")
    public CarNameArray test2(){
        return carNameArray;
    }

    /**
     * # 自定义配置项3  List数据 List<String>
     *
     * @return
     */
    @RequestMapping("/test3.do")
    public CarNameList test3(){
        return carNameList;
    }

    /**
     * # 自定义配置项4  List数据 List<类类型>
     *
     * @return
     */
    @RequestMapping("/test4.do")
    public CarList test4(){
        return carList;
    }

    /**
     * # 自定义配置项5 Map<String, 类类型>
     *
     * @return
     */
    @RequestMapping("/test5.do")
    public CarMap test5(){
        return carMap;
    }

    @RequestMapping("/test6.do")
    public ClassNestClass test6(){
        return classNestClass;
    }

    @RequestMapping("/test7.do")
    public MapperPath test7() {
        return mapperPath;
    }

}
