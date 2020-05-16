package com.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 产品线枚举
 */
@Getter
@AllArgsConstructor
public enum ProductLine {

    BJC("对公众业务",1),
    TCX("对私人业务",2);

    /** 描述 */
    private String description;
    /** 编码 */
    private Integer code;

    public static ProductLine of(Integer code) throws IllegalAccessException {
        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(data -> data.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalAccessException("nosucuCode"));
    }
}
