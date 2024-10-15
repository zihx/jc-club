package com.jingdianjichi.auth.common.enums;

import lombok.Getter;

/**
 * ClassName: AuthUserStatusEnum
 * Package: com.jingdianjichi.auth.common.enums
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/12 21:07
 * @Version 1.0
 */
@Getter
public enum StatusEnum {

    OPEN(0,"启用"),
    CLOSE(1,"禁用");

    private int code;
    private String desc;

    StatusEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
