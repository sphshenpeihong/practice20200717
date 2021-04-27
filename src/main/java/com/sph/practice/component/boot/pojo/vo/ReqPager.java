package com.sph.practice.component.boot.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/4/27
 */
@Data
@AllArgsConstructor
public class ReqPager {

    // 当前第几页
    private int currentPage;

    // 每页查询条数
    private int pageSize;

}
