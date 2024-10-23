package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.OptionDTO;
import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.domain.bo.OptionBO;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T16:44:16+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_212 (Oracle Corporation)"
)
public class SubjectInfoDTOConverterImpl implements SubjectInfoDTOConverter {

    @Override
    public SubjectInfoBO convert(SubjectInfoDTO subjectInfoDTO) {
        if ( subjectInfoDTO == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        subjectInfoBO.setPageNo( subjectInfoDTO.getPageNo() );
        subjectInfoBO.setPageSize( subjectInfoDTO.getPageSize() );
        subjectInfoBO.setId( subjectInfoDTO.getId() );
        subjectInfoBO.setSubjectName( subjectInfoDTO.getSubjectName() );
        subjectInfoBO.setSubjectDifficult( subjectInfoDTO.getSubjectDifficult() );
        subjectInfoBO.setSettleName( subjectInfoDTO.getSettleName() );
        subjectInfoBO.setSubjectType( subjectInfoDTO.getSubjectType() );
        subjectInfoBO.setSubjectScore( subjectInfoDTO.getSubjectScore() );
        subjectInfoBO.setSubjectParse( subjectInfoDTO.getSubjectParse() );
        subjectInfoBO.setSubjectAnswer( subjectInfoDTO.getSubjectAnswer() );
        List<Long> list = subjectInfoDTO.getCategoryIds();
        if ( list != null ) {
            subjectInfoBO.setCategoryIds( new ArrayList<Long>( list ) );
        }
        List<Long> list1 = subjectInfoDTO.getLabelIds();
        if ( list1 != null ) {
            subjectInfoBO.setLabelIds( new ArrayList<Long>( list1 ) );
        }
        subjectInfoBO.setOptionList( optionDTOListToOptionBOList( subjectInfoDTO.getOptionList() ) );
        subjectInfoBO.setCategoryId( subjectInfoDTO.getCategoryId() );
        subjectInfoBO.setLabelId( subjectInfoDTO.getLabelId() );
        List<String> list3 = subjectInfoDTO.getLabelName();
        if ( list3 != null ) {
            subjectInfoBO.setLabelName( new ArrayList<String>( list3 ) );
        }

        return subjectInfoBO;
    }

    @Override
    public SubjectInfoDTO convert(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectInfoDTO subjectInfoDTO = new SubjectInfoDTO();

        subjectInfoDTO.setPageNo( subjectInfoBO.getPageNo() );
        subjectInfoDTO.setPageSize( subjectInfoBO.getPageSize() );
        subjectInfoDTO.setId( subjectInfoBO.getId() );
        subjectInfoDTO.setSubjectName( subjectInfoBO.getSubjectName() );
        subjectInfoDTO.setSubjectDifficult( subjectInfoBO.getSubjectDifficult() );
        subjectInfoDTO.setSettleName( subjectInfoBO.getSettleName() );
        subjectInfoDTO.setSubjectType( subjectInfoBO.getSubjectType() );
        subjectInfoDTO.setSubjectScore( subjectInfoBO.getSubjectScore() );
        subjectInfoDTO.setSubjectParse( subjectInfoBO.getSubjectParse() );
        subjectInfoDTO.setSubjectAnswer( subjectInfoBO.getSubjectAnswer() );
        subjectInfoDTO.setOptionList( optionBOListToOptionDTOList( subjectInfoBO.getOptionList() ) );
        List<Long> list1 = subjectInfoBO.getCategoryIds();
        if ( list1 != null ) {
            subjectInfoDTO.setCategoryIds( new ArrayList<Long>( list1 ) );
        }
        List<Long> list2 = subjectInfoBO.getLabelIds();
        if ( list2 != null ) {
            subjectInfoDTO.setLabelIds( new ArrayList<Long>( list2 ) );
        }
        subjectInfoDTO.setCategoryId( subjectInfoBO.getCategoryId() );
        subjectInfoDTO.setLabelId( subjectInfoBO.getLabelId() );
        List<String> list3 = subjectInfoBO.getLabelName();
        if ( list3 != null ) {
            subjectInfoDTO.setLabelName( new ArrayList<String>( list3 ) );
        }

        return subjectInfoDTO;
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

    protected List<OptionBO> optionDTOListToOptionBOList(List<OptionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<OptionBO> list1 = new ArrayList<OptionBO>( list.size() );
        for ( OptionDTO optionDTO : list ) {
            list1.add( optionDTOToOptionBO( optionDTO ) );
        }

        return list1;
    }

    protected OptionDTO optionBOToOptionDTO(OptionBO optionBO) {
        if ( optionBO == null ) {
            return null;
        }

        OptionDTO optionDTO = new OptionDTO();

        optionDTO.setOptionType( optionBO.getOptionType() );
        optionDTO.setOptionContent( optionBO.getOptionContent() );
        optionDTO.setIsCorrect( optionBO.getIsCorrect() );

        return optionDTO;
    }

    protected List<OptionDTO> optionBOListToOptionDTOList(List<OptionBO> list) {
        if ( list == null ) {
            return null;
        }

        List<OptionDTO> list1 = new ArrayList<OptionDTO>( list.size() );
        for ( OptionBO optionBO : list ) {
            list1.add( optionBOToOptionDTO( optionBO ) );
        }

        return list1;
    }
}
