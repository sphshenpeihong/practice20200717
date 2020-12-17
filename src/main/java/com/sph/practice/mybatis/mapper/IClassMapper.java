package com.sph.practice.mybatis.mapper;

import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.vo.CSVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/13 3:02
 * Description: Class表测试
 *
 * @since 1.0.0
 */
//@Mapper
public interface IClassMapper {

    //单表单数据查询 通过主键id查询
    public QyClassPO getClassById(int id);

    //将传参放到map当中
    public List<QyClassPO> getClassByMap(Map<String, Object> map);

    //批量查询数据
    public List<QyClassPO> getClassByIds(List<Integer> ids);

    //通过类类型查询数据
    public QyClassPO getClassByVO(@Param("vo") CSVO vo);

    //多表查询
    public List<CSVO> getCSVOByClassId(@Param("id") Integer id);

}
