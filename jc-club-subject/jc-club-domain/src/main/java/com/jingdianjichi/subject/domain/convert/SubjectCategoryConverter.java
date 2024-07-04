package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectCategoryMapper;
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
public interface SubjectCategoryConverter {
    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convert(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convert(List<SubjectCategory> subjectCategoryList);
}
