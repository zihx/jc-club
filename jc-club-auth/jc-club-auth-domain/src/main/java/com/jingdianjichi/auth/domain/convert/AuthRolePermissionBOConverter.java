package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.bo.AuthRolePermissionBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName: AuthRolePermissionBOConverter
 * Package: com.jingdianjichi.auth.domain.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/16 16:23
 * @Version 1.0
 */
@Mapper
public interface AuthRolePermissionBOConverter {
    AuthRolePermissionBOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionBOConverter.class);

    AuthRolePermission convert(AuthRolePermissionBO authRolePermissionBO);
}
