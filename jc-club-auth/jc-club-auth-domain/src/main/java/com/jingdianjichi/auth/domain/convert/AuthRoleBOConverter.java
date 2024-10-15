package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.bo.AuthRoleBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;

/**
 * ClassName: AuthRoleBOConverter
 * Package: com.jingdianjichi.auth.domain.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:06
 * @Version 1.0
 */
@Mapper
public interface AuthRoleBOConverter {
    AuthRoleBOConverter INSTANCE = org.mapstruct.factory.Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convert(AuthRoleBO authRoleBO);
}
