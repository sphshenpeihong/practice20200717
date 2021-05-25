package com.sph.practice.test.mapstruct.convert.worker;

import com.alibaba.fastjson.JSON;
import com.sph.practice.test.mapstruct.pojo.bo.MapStructSonBO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

/**
 * mapstruct类型转换
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@Component
@Named("TypeConversionWorker")
public class TypeConversionWorker {

    /**
     * json字符串转对象
     *
     * @param jsonString
     * @return
     */
    @Named("jsonStringToObject")
    public MapStructSonBO jsonStringToObject(String jsonString) {
        return StringUtils.isBlank(jsonString) ? null : JSON.parseObject(jsonString, MapStructSonBO.class);
    }

}
