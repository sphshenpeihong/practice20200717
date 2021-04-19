package com.sph.practice.component.boot.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by Shen Peihong on 2021/4/14
 * Description: 返回给前端的业务VO类
 *
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Integer code;
    private String desc;
    private Object data;

    public static ResponseEntity<Response> ok(Object data) {
        return ResponseEntity.ok(new Response(RespEnum.OK.getCode(), RespEnum.OK.getDesc(), data));
    }

}
