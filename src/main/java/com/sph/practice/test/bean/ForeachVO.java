package com.sph.practice.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/22 14:27
 * Description:
 *
 * @since 1.0.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ForeachVO {
    private String id;
    private List<AccountPO> AccountPOList;
}
