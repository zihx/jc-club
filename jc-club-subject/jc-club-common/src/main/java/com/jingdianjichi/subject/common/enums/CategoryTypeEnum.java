package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

/**
 * ClassName: CategoryTypeEnum
 * Package: com.jingdianjichi.subject.common.enums
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 20:55
 * @Version 1.0
 */
@Getter
public enum CategoryTypeEnum {
    Primary(1, "岗位大类"),
    Second(2, "二级分类");

    private Integer code;
    private String desc;

    CategoryTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}