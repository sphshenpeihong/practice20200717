package com.sph.practice.mybatisplus.controller;

import com.sph.practice.component.boot.resp.Response;
import com.sph.practice.component.exception.BaseException;
import com.sph.practice.mybatisplus.pojo.bo.XRayLeakagePackageBO;
import com.sph.practice.mybatisplus.pojo.dto.LeakagePackageDTO;
import com.sph.practice.mybatisplus.service.XRayBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Slf4j
@RestController
@RequestMapping("/business")
public class XRayBusinessController {

    @Resource
    private XRayBusinessService xRayBusinessService;

    /**
     * 处理X光机漏包数据并导出excel
     *
     * @return 返参
     * @throws Exception     异常
     * @throws BaseException 自定义异常
     */
    @PostMapping("/handleXRayLeakagePackage")
    public ResponseEntity<Response> handleXRayLeakagePackage(@RequestBody LeakagePackageDTO dto) throws Exception, BaseException {
        // 查询数据
        List<XRayLeakagePackageBO> leakagePackageList = xRayBusinessService.getLeakagePackageList(dto);
        // 处理数据，并导出excel
        xRayBusinessService.handleXRayLeakagePackage(leakagePackageList);
        // 响应前端
        return Response.ok();
    }

}
