package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.OptionDTO;
import com.jingdianjichi.subject.domain.bo.OptionBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T21:51:34+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class OptionDTOConverterImpl implements OptionDTOConverter {

    @Override
    public List<OptionBO> convert(List<OptionDTO> optionDTOList) {
        if ( optionDTOList == null ) {
            return null;
        }

        List<OptionBO> list = new ArrayList<OptionBO>( optionDTOList.size() );
        for ( OptionDTO optionDTO : optionDTOList ) {
            list.add( optionDTOToOptionBO( optionDTO ) );
        }

        return list;
    }

    protected OptionBO optionDTOToOptionBO(OptionDTO optionDTO) {
        if ( optionDTO == null ) {
            return null;
        }

        OptionBO optionBO = new OptionBO();

        optionBO.setOptionType( optionDTO.getOptionType() );
        optionBO.setOptionContent( optionDTO.getOptionContent() );
        optionBO.setIsCorrect( optionDTO.getIsCorrect() );

        return optionBO;
    }
}
