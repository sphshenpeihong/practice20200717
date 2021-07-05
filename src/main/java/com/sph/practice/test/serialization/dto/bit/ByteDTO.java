package com.sph.practice.test.serialization.dto.bit;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据传输
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Data
public class ByteDTO extends ByteParentDTO {

    private transient Integer id;

    private String username;

    private String password;

    private Integer sex;

    private ByteRefDTO refDTO;

}
