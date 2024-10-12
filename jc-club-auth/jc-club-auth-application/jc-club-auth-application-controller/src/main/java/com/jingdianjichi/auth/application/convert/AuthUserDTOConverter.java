package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import org.mapstruct.Mapper;

/**
 * ClassName: AuthUserDTOConverter
 * Package: com.jingdianjichi.auth.application.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/12 20:25
 * @Version 1.0
 */
@Mapper
public interface AuthUserDTOConverter {
    AuthUserDTOConverter INSTANCE = org.mapstruct.factory.Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUserBO convert(AuthUserDTO authUserDTO);
}
