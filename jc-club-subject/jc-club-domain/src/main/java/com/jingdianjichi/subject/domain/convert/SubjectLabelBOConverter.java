package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.bo.SubjectLabelBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: SubjectLabelBOConverter
 * Package: com.jingdianjichi.subject.domain.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/7 21:01
 * @Version 1.0
 */
@Mapper
public interface SubjectLabelBOConverter {
    SubjectLabelBOConverter INSTANCE = Mappers.getMapper(SubjectLabelBOConverter.class);

    SubjectLabel convert(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convert(List<SubjectLabel> subjectLabelList);
}
