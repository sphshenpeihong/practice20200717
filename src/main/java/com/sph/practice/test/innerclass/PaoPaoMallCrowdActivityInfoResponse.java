package com.sph.practice.test.innerclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
@EqualsAndHashCode
public class PaoPaoMallCrowdActivityInfoResponse {
    private String code;
    private String msg;
    private PaoPaoMallCrowdActivityInfoResponseData data;

    public boolean isSuccess() {
        return "A00000".equals(code) && data != null;
    }

    @Data
    public class PaoPaoMallCrowdActivityInfoResponseData {
        private long activityId;
        private int orderNum;
        private int targetNum;
        private long startTime;
        private long endTime;
    }
}