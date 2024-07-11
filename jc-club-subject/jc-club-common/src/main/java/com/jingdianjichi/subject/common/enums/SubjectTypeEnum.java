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
public enum SubjectTypeEnum {
    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答");

    private Integer code;
    private String desc;

    SubjectTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectTypeEnum getByCode(Integer code) {
        for (SubjectTypeEnum typeEnum : SubjectTypeEnum.values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}