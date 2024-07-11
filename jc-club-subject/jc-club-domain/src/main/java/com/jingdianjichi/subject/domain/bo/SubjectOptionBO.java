package com.jingdianjichi.subject.domain.bo;

import lombok.Data;

import java.util.List;

/**
 * ClassName: SubjectAnswer
 * Package: com.jingdianjichi.subject.application.dto
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 15:45
 * @Version 1.0
 */
@Data
public class SubjectOptionBO {
    private String subjectAnswer;

    private List<OptionBO> optionList;
}
