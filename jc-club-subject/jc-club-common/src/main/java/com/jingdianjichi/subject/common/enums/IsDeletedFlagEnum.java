package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

/**
 * ClassName: IsDeletedFlagEnum
 * Package: com.jingdianjichi.subject.common.enums
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 20:14
 * @Version 1.0
 */
@Getter
public enum IsDeletedFlagEnum {
    DELETED(1, "已删除"),
    UN_DELETED(0, "未删除");

    private Integer code;
    private String desc;

    IsDeletedFlagEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
