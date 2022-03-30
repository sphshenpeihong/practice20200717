package com.sph.practice.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sph.practice.mybatis.vo.CSVO;
import com.sph.practice.mybatisplus.pojo.po.QyPlusUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Shen Peihong on 2021/1/26
 * Description:
 *
 * @since 1.0.0
 */

public interface PlusUserMapper extends BaseMapper<QyPlusUser> {

    /**
     * 多表联合分页
     *
     * @param page
     * @param name
     */
    List<CSVO> pageList(IPage<CSVO> page, @Param("id") Integer id);

    List<CSVO> pageList(@Param("id") Integer id, IPage<CSVO> page);

}
