package com.sph.practice.mybatis.mapper;

import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.vo.Param1VO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/19 20:00
 * Description: 用户Mapper
 *
 * @since 1.0.0
 */
public interface IUserMapper {

    //简单通过id查询user表
    public QyUserPO getUserById(Integer id) throws Exception;

    //查找全部
    public List<QyUserPO> getAllUser();

    /**
     * 通过某些id去查询，查询SQL返回值用map接收
     *
     * @param paramMap
     * @return
     * @throws Exception
     * @author Shen Peihong
     * @date 2021/1/19
     */
    Map<String, Object> getMapByIds(Map<String, Object> paramMap) throws Exception;

    /**
     * 查询一条数据取别名
     *
     * @param id
     * @return
     * @throws Exception
     * @author Shen Peihong
     * @date 2021/1/19
     */
    @Select("select id,user_name as userNamea from qy_user where id = #{id}")
    Param1VO selectOne(@Param("id") Integer id) throws Exception;

    /**
     * XML单表查询，resultMap手动映射
     *
     * @return
     * @throws Exception
     * @author Shen Peihong
     * @date 2021/1/19
     */
    Param1VO selectOne1(@Param("id") Integer id) throws Exception;

}
