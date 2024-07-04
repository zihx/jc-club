package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

/**
 * ClassName: ResultCode
 * Package: com.jingdianjichi.subject.common.enums
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 13:40
 * @Version 1.0
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    private Integer code;
    private String desc;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
