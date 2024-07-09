package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.bo.SubjectCategoryBO;
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

    SubjectCategory convert(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convert(List<SubjectCategory> subjectCategoryList);
}
