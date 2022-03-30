package com.sph.practice.mybatis.mapper;

import com.sph.practice.mybatis.pojo.QyClassPO;
import com.sph.practice.mybatis.pojo.QyStudentPO;
import com.sph.practice.mybatis.vo.CSVO;
import com.sph.practice.mybatis.vo.CSVO1;
import com.sph.practice.mybatis.vo.ClassVO;
import com.sph.practice.mybatis.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/13 3:02
 * Description: Class表测试
 *
 * @since 1.0.0
 */
public interface IClassMapper<T> {

    //单表单数据查询 通过主键id查询
    public QyClassPO getClassById(int id);

    //将传参放到map当中
    public List<QyClassPO> getClassByMap(Map<String, Object> map);

    //批量查询数据
    public List<QyClassPO> getClassByIds(List<Integer> ids);

    //批量查询数据（入参用String[]）
    public List<QyClassPO> getClassByIds1(Integer[] asaxasxas);

    //通过类类型查询数据
    public QyClassPO getClassByVO(@Param("vo") CSVO vo);

    //多表查询
    public List<CSVO> getCSVOByClassId(@Param("id") Integer id);


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

    // 关联班级、学生表，查出List数据
    List<CSVO> getCSVOList1(@Param("classId") Integer classId);


    //返参类型是多对一的方式
    List<StudentVO> getStudent();

    //返参类型是一对多的方式
    ClassVO getClassVO();


    //一对多，返参List
    List<ClassVO> getClassVOList();

    //动态SQL查询学生
    List<QyStudentPO> getUserList(Map<String, Object> paramMap);

    //SQL使用or 看看where支不支持去or
    List<QyStudentPO> getUserList1(Map<String, Object> paramMap);

    //找到 id = 1~3的数据
    List<QyStudentPO> getUserListByIds(Map<String, Object> paramMap);



}
