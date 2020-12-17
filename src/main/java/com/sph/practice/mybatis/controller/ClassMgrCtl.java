package com.sph.practice.mybatis.controller;

import com.google.common.collect.Lists;
import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.service.IClassService;
import com.sph.practice.mybatis.vo.CSVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/13 12:10
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/class/mgr")
public class ClassMgrCtl {

    @Resource(name = "classService")
    private IClassService classService;

    @RequestMapping("/test1.do")
    public void test1(Integer id) throws Exception{
        if (id == null){
            throw new Exception("id参数不能为空");
        }
        QyClassPO PO = classService.getClassById(id);
        System.out.println(PO);
    }

    @RequestMapping("/test2.do")
    public void test2(Integer id){
        List<QyClassPO> poList = classService.getClassByMap(id);
        for (QyClassPO po : poList) {
            System.out.println(po);
        }
    }

    @RequestMapping("/test3.do")
    public void test3(){
        List<QyClassPO> poList = classService.getClassByIds(Lists.newArrayList(1, 2, 3));
        for (QyClassPO po : poList) {
            System.out.println(po);
        }
    }

    @RequestMapping("/test4.do")
    public void test4(){
        CSVO csvo = new CSVO();
        csvo.setClassId(1);
        QyClassPO PO = classService.getClassByVO(csvo);
        System.out.println(PO);
    }

    @RequestMapping("/test5.do")
    public void test5(Integer id){
        List<CSVO> list = classService.getCSVOByClassId(id);
        for (CSVO csvo : list) {
            System.out.println(csvo);
        }
    }

}
