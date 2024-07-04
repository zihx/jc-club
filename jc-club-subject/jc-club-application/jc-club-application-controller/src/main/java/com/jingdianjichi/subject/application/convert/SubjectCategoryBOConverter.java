package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
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
public interface SubjectCategoryBOConverter {
    SubjectCategoryBOConverter INSTANCE = Mappers.getMapper(SubjectCategoryBOConverter.class);

    SubjectCategoryBO convert(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convert(List<SubjectCategoryBO> subjectCategoryBOList);
}
