package com.sph.practice.test.elk.controller;

import com.alibaba.fastjson.JSON;
import com.sph.practice.test.elk.dto.SpecificLogDTO;
import com.sph.practice.test.elk.util.ELKUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Slf4j
@RestController
@RequestMapping("/printLog")
public class PrintLogCtl {

    private final static Logger crLogger = LoggerFactory.getLogger("asyncBizLoggerAppenderCR");

    // 打印正常文本日志
    @RequestMapping("textLog")
    public void textLog(String logString) {
        log.info(logString);
    }

    // 打印特定日志
    @RequestMapping("specificLog")
    public void specificLog(@RequestBody SpecificLogDTO dto) {
        crLogger.info(ELKUtil.ELK_SPECIFIC_LOG_SPLIT + JSON.toJSONString(dto));
    }


}
