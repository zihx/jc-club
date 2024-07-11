package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.OptionDTO;
import com.jingdianjichi.subject.domain.bo.OptionBO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * ClassName: OptionDTOConverter
 * Package: com.jingdianjichi.subject.application.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:31
 * @Version 1.0
 */
@Mapper
public interface OptionDTOConverter {
    OptionDTOConverter INSTANCE = org.mapstruct.factory.Mappers.getMapper(OptionDTOConverter.class);

    List<OptionBO> convert(List<OptionDTO> optionDTOList);
}
