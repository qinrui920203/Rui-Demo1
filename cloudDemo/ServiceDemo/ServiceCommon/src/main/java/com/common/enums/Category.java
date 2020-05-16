package com.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Category {

    MANJIAN("满减", "001"),
    ZHEKOU("折扣","002"),
    LIJIAN("折扣","003");

    /** 描述 */
    private String description;

    /** 分类 */
    private String code;

    public static Category of(String code) throws IllegalAccessException {
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(s -> s.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalAccessException(code + "no such code"));
    }
}
