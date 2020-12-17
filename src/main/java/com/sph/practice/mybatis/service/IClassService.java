package com.sph.practice.mybatis.service;

import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.vo.CSVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/13 12:06
 * Description:
 *
 * @since 1.0.0
 */
public interface IClassService {

    //单表单数据查询 通过主键id查询
    public QyClassPO getClassById(Integer id);

    //将传参放到map当中
    public List<QyClassPO> getClassByMap(Integer id);

    //批量查询数据
    public List<QyClassPO> getClassByIds(List<Integer> ids);

    //通过类类型查询数据
    public QyClassPO getClassByVO(CSVO vo);

    //多表查询
    public List<CSVO> getCSVOByClassId(Integer id);

}
