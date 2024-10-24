package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.domain.bo.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: SubjectCategoryConverter
 * Package: com.jingdianjichi.subject.domain.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 11:40
 * @Version 1.0
 */
@Mapper
public interface SubjectCategoryDTOConverter {
    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convert(SubjectCategoryDTO subjectCategoryDTO);

    SubjectCategoryDTO convert(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryDTO> convert(List<SubjectCategoryBO> subjectCategoryBOList);
}
