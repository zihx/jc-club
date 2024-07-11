package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: SubjectInfoDTOConverter
 * Package: com.jingdianjichi.subject.application.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:16
 * @Version 1.0
 */
@Mapper
public interface SubjectInfoDTOConverter {
    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convert(SubjectInfoDTO subjectInfoDTO);

    // List<SubjectInfoDTO> convert(List<SubjectInfoBO> subjectInfoBOList);

    SubjectInfoDTO convert(SubjectInfoBO subjectInfoBO);
}
