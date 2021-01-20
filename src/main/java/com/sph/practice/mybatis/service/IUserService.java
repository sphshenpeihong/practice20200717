package com.sph.practice.mybatis.service;

import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.vo.Param1VO;

import java.util.List;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/12/23 19:49
 * Description:
 *
 * @since 1.0.0
 */
public interface IUserService {

    //通过Id找用户
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
    Param1VO selectOne(Integer id) throws Exception;

    /**
     * XML单表查询，resultMap手动映射
     *
     * @return
     * @throws Exception
     * @author Shen Peihong
     * @date 2021/1/19
     */
    Param1VO selectOne1(Integer id) throws Exception;



}
