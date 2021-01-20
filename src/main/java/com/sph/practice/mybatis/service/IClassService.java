package com.sph.practice.mybatis.service;

import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.vo.CSVO;
import com.sph.practice.mybatis.vo.CSVO1;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 这里多表连接查询1班学生
     *
     * @param classId
     * @return
     * @author Shen Peihong
     * @date 2021/1/19
     */

    List<CSVO> getCSVOList(@Param("classId") Integer classId);

    /**
     * 定义一个VO，包含多的List，resultMap在映射字段与属性的时候，利用association连接起来
     *
     * @param paramMap
     * @return
     * @author Shen Peihong
     * @date 2021/1/20
     */
    List<CSVO1> getCSVO1(Map<String, Object> paramMap);

}
