package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.domain.bo.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName: AuthPermissionDTOConverter
 * Package: com.jingdianjichi.auth.application.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:09
 * @Version 1.0
 */
@Mapper
public interface AuthPermissionDTOConverter {
    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convert(AuthPermissionDTO authPermissionDTO);
}
