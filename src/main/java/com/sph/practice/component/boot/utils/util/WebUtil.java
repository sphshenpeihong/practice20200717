package com.sph.practice.component.boot.utils.util;

import com.sph.practice.component.boot.pojo.vo.ReqPager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/4/27
 */
public class WebUtil {

    /**
     * 获取查询分页参数
     *
     * @return
     */
    public static ReqPager getReqPager() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        int currentPage = getParam(request, "currentPage", 1);
        int pageSize = getParam(request, "pageSize", 10);
        return new ReqPager(currentPage, pageSize);
    }

    /**
     * 获取查询分页参数
     *
     * @param request
     * @return
     */
    public static ReqPager getReqPager(HttpServletRequest request) {
        int currentPage = getParam(request, "currentPage", 1);
        int pageSize = getParam(request, "pageSize", 10);
        return new ReqPager(currentPage, pageSize);
    }

    /**
     * 获取指定入参的值
     *
     * @param request
     * @param paramName
     * @param defaultValue
     */
    private static int getParam(HttpServletRequest request, String paramName, int defaultValue){
        String paramValue = request.getParameter(paramName);
        if (StringUtils.isEmpty(paramValue)){
            paramValue = (String) request.getAttribute(paramName);
        }
        return StringUtils.isNotEmpty(paramValue) ? Integer.parseInt(paramValue) : defaultValue;
    }

}
