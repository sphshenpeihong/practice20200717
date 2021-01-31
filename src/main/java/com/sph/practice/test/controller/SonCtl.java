package com.sph.practice.test.controller;

import com.sph.practice.test.controller.bean.DateBean;
import com.sph.practice.test.param.ResultVO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shen Peihong on 2020/9/13 16:36
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test/son")
public class SonCtl extends ParentCtl{

    @Resource(name = "transactionManager")
    private DataSourceTransactionManager transactionManager;

    @RequestMapping(path = "/son.do")
    public void getPrint(){
        System.out.println(transactionManager);
        System.out.println("SonCtl ..");
    }

    @RequestMapping(path = "/test1.do")
    public ResultVO test1(@DateTimeFormat Date date){
        ResultVO resultVO = new ResultVO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        resultVO.setResult(format);
        return resultVO;
    }

}
