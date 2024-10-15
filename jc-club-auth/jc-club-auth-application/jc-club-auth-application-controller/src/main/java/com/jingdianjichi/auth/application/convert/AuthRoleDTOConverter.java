package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRoleDTO;
import com.jingdianjichi.auth.domain.bo.AuthRoleBO;
import org.mapstruct.Mapper;

/**
 * ClassName: AuthRoleDTOConverter
 * Package: com.jingdianjichi.auth.application.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:05
 * @Version 1.0
 */
@Mapper
public interface AuthRoleDTOConverter {
    AuthRoleDTOConverter INSTANCE = org.mapstruct.factory.Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convert(AuthRoleDTO authRoleDTO);
}
