package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;

/**
 * ClassName: AuthUserBOConverter
 * Package: com.jingdianjichi.auth.domain.convert
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/12 20:32
 * @Version 1.0
 */
@Mapper
public interface AuthUserBOConverter {
    AuthUserBOConverter INSTANCE = org.mapstruct.factory.Mappers.getMapper(AuthUserBOConverter.class);

    AuthUser convert(AuthUserBO authUserBO);

    AuthUserBO convert(AuthUser authUser);
}
