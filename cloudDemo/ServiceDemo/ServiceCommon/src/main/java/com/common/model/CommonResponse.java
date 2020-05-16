package com.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {
    private Integer code; // 0 为正常  1为异常
    private String message;  // 异常状态信息
    private T data;  // 真实数据

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
