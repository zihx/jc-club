package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.bo.AuthPermissionBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import org.mapstruct.Mapper;

/**
 * ClassName: AuthPermissionBOConverter
 * Package: com.jingdianjichi.auth.domain.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:07
 * @Version 1.0
 */
@Mapper
public interface AuthPermissionBOConverter {
    AuthPermissionBOConverter INSTANCE = org.mapstruct.factory.Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermission convert(AuthPermissionBO authPermissionBO);
}
