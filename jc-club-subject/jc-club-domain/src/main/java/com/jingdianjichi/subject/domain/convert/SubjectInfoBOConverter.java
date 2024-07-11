package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.bo.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: SubjectInfoBOConverter
 * Package: com.jingdianjichi.subject.domain.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:19
 * @Version 1.0
 */
@Mapper
public interface SubjectInfoBOConverter {
    SubjectInfoBOConverter INSTANCE = Mappers.getMapper(SubjectInfoBOConverter.class);

    SubjectInfo convert(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> convert(List<SubjectInfo> subjectInfos);

    SubjectInfoBO convert(SubjectInfo subjectInfo, SubjectOptionBO subjectOptionBO);
}
