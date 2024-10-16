package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO;
import com.jingdianjichi.auth.domain.bo.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName: AuthRolePermissionDTOConverter
 * Package: com.jingdianjichi.auth.application.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/16 16:23
 * @Version 1.0
 */
@Mapper
public interface AuthRolePermissionDTOConverter {
    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBO convert(AuthRolePermissionDTO authRolePermissionDTO);
}
