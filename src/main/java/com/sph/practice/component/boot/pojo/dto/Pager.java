package com.sph.practice.component.boot.pojo.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

/**
 * 格式化各种分页对象
 *
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/4/26
 */
@Data
public class Pager implements Serializable {
    // 当前页
    private int currentPage;

    // 想要查询的条数（前端不传，默认10）
    private int pageSize;

    // 查询结果条数
    private int resultSize;

    // 分页数据
    private Collection pageData;

    // 总条数
    private long totalRows;

    // 总页数
    private int totalPages;

    // 是否是第一页
    private boolean hasFirstPage;

    // 是否是最后一页
    private boolean hasLastPage;

    //是否有上一页
    private boolean hasPreviousPage;

    //是否有下一页
    private boolean hasNextPage;

    // ********** 格式化PageInfo(利用PageHelper分页查询) start *******
    public static Pager formatRespPage(PageInfo pageInfo){
        return new Pager(pageInfo);
    }

    private Pager(PageInfo pageInfo) {
        currentPage = pageInfo.getPageNum();
        pageSize = pageInfo.getPageSize();
        resultSize = pageInfo.getSize();
        pageData = pageInfo.getList();
        totalRows = pageInfo.getTotal();
        totalPages = pageInfo.getPages();
        hasFirstPage = pageInfo.isIsFirstPage();
        hasLastPage = pageInfo.isIsLastPage();
        hasPreviousPage = pageInfo.isHasPreviousPage();
        hasNextPage = pageInfo.isHasNextPage();
    }
    // ********** 格式化PageInfo(利用PageHelper分页查询) end *******


    // ********** 格式化MyabtisPlus的分页对象 start *******
    public static Pager formatRespPage(IPage page) {
        return new Pager(page);
    }

    private Pager(IPage page) {
        currentPage = (int) (page.getCurrent() <= 1 ? 1 : page.getCurrent());
        pageSize = (int) page.getSize();
        resultSize = page.getRecords().size();
        pageData = page.getRecords();
        totalRows = page.getTotal();
        totalPages = (int) page.getPages();
        hasFirstPage = currentPage == 1 ? true : false;
        hasLastPage = currentPage >= totalPages ? true : false;
        hasPreviousPage = ((Page) page).hasPrevious();
        hasNextPage = ((Page) page).hasNext();

    }
    // ********** 格式化MyabtisPlus的分页对象 end *******

}
