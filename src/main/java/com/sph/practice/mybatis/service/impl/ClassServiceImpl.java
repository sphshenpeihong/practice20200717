package com.sph.practice.mybatis.service.impl;

import com.google.common.collect.Lists;
import com.sph.practice.mybatis.mapper.IClassMapper;
import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.pojo.QyStudentPO;
import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.service.IClassService;
import com.sph.practice.mybatis.vo.CSVO;
import com.sph.practice.mybatis.vo.CSVO1;
import com.sph.practice.mybatis.vo.ClassVO;
import com.sph.practice.mybatis.vo.StudentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/13 12:06
 * Description:
 *
 * @since 1.0.0
 */
@Service("classService")
public class ClassServiceImpl implements IClassService {


    @Resource
    private IClassMapper classMapper;

    @Override
    public QyClassPO getClassById(Integer id) {
        if (id == null){
            return null;
        }
        return classMapper.getClassById(id);
    }

    @Override
    public List<QyClassPO> getClassByMap(Integer id) {
        CSVO csvo = new CSVO();
        csvo.setClassId(2);
        Map<String, Object> map = new HashMap<String, Object>(){{
            put("ids", Lists.newArrayList(1,2,3,4));
            put("className","班级二");
            put("csvo", csvo);
        }};
        return classMapper.getClassByMap(map);
    }

    @Override
    public List<QyClassPO> getClassByIds(List<Integer> ids) {
        return classMapper.getClassByIds(ids);
    }

    @Override
    public QyClassPO getClassByVO(CSVO vo) {
        return classMapper.getClassByVO(vo);
    }

    @Override
    public List<CSVO> getCSVOByClassId(Integer id) {
        return classMapper.getCSVOByClassId(id);
    }

    @Override
    public List<CSVO> getCSVOList(Integer classId) {
        return classMapper.getCSVOList(classId);
    }

    @Override
    public List<CSVO1> getCSVO1(Map<String, Object> paramMap) {
        return classMapper.getCSVO1(paramMap);
    }

    @Override
    public List<CSVO> getCSVOList1(Integer classId) {
        return classMapper.getCSVOList1(classId);
    }

    @Override
    public List<StudentVO> getStudent() {
        return classMapper.getStudent();
    }

    @Override
    public ClassVO getClassVO() {
        return classMapper.getClassVO();
    }

    @Override
    public List<ClassVO> getClassVOList() {
        return classMapper.getClassVOList();
    }

    @Override
    public List<QyStudentPO> getUserList(Map<String, Object> paramMap) {
        return classMapper.getUserList(paramMap);
    }

    @Override
    public List<QyStudentPO> getUserList1(Map<String, Object> paramMap) {
        return classMapper.getUserList1(paramMap);
    }

    @Override
    public List<QyStudentPO> getUserListByIds(Map<String, Object> paramMap) {
        return classMapper.getUserListByIds(paramMap);
    }


}
