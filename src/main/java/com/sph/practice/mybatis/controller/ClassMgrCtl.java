package com.sph.practice.mybatis.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sph.practice.mybatis.mapper.IUserMapper;
import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.pojo.QyStudentPO;
import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.service.IClassService;
import com.sph.practice.mybatis.util.ApplicationContextUtil;
import com.sph.practice.mybatis.util.GenericClass;
import com.sph.practice.mybatis.vo.CSVO;
import com.sph.practice.mybatis.vo.CSVO1;
import com.sph.practice.mybatis.vo.ClassVO;
import com.sph.practice.mybatis.vo.StudentVO;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        IClassService classService1 = ApplicationContextUtil.getBean("classService", IClassService.class);
        List<QyClassPO> poList = classService1.getClassByMap(id);
        for (QyClassPO po : poList) {
            System.out.println(po);
        }
    }

    @RequestMapping("/test21.do")
    public void test21(Integer id) throws Exception {
        IUserMapper classService1 = ApplicationContextUtil.getBean("userMapper", IUserMapper.class);
        QyUserPO userById = classService1.getUserById(id);
        /*for (QyClassPO po : poList) {
            System.out.println(po);
        }*/
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
    public void test5(Integer id, CSVO csvo1){
        List<CSVO> list = classService.getCSVOByClassId(id);
        for (CSVO csvo : list) {
            System.out.println(csvo1);
        }
    }

    @RequestMapping("/test6.do")
    public void test6(){
        List<CSVO> list = classService.getCSVOList(1);
        System.out.println(list);
    }

    @RequestMapping("/test7.do")
    public void test7(){
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("classIdList", Lists.newArrayList(1,2));
        List<CSVO1> list = classService.getCSVO1(paramMap);
        System.out.println(list);
    }

    @RequestMapping("/test8.do")
    public void test8(){

        List<CSVO> csvoList1 = classService.getCSVOList1(1);
        System.out.println(csvoList1);
    }


    @RequestMapping("/test9.do")
    public void test9(){

        List<StudentVO> studentVOList = classService.getStudent();
        System.out.println(studentVOList);
    }

    @RequestMapping("/test10.do")
    public void test10(){
        // 有加：1
        //没加 ：2
        ClassVO classVO = classService.getClassVO();
        System.out.println(classVO);
    }

    @RequestMapping("/test11.do")
    public void test11(){

        List<ClassVO> classVOList = classService.getClassVOList();
        System.out.println(classVOList);
    }

    @RequestMapping("/test12.do")
    public void test12(){

        Map paramMap = new HashMap<String, Object>() {
            {
                put("studentName", "刘一");
                put("classId", 1);
            }
        };
        List<QyStudentPO> qyStudentPOList = classService.getUserList(paramMap);
        System.out.println(qyStudentPOList);
    }

    @RequestMapping("/test13.do")
    public void test13(){

        Map paramMap = new HashMap<String, Object>() {
            {
                put("studentName", "张三");
                put("classId", 1);
            }
        };
        List<QyStudentPO> qyStudentPOList = classService.getUserList1(paramMap);
        System.out.println(qyStudentPOList);
    }

    @RequestMapping("/test14.do")
    public void test14(){

        Map paramMap = new HashMap<String, Object>() {
            {
                put("idList", Lists.newArrayList(1,2,3));
            }
        };
        List<QyStudentPO> qyStudentPOList = classService.getUserListByIds(paramMap);
        System.out.println(qyStudentPOList);
    }

    /**
     *
     */
    @Test
    public void test(){
        Integer i = GenericClass.i;
    }

}
