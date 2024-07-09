package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectLabelDTO;
import com.jingdianjichi.subject.domain.bo.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: SubjectLabelDTOConverter
 * Package: com.jingdianjichi.subject.application.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/7 21:00
 * @Version 1.0
 */
@Mapper
public interface SubjectLabelDTOConverter {
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convert(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convert(List<SubjectLabelBO> subjectLabelBOList);
}
