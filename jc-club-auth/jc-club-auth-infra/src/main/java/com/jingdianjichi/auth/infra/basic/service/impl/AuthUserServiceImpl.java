package com.jingdianjichi.auth.infra.basic.service.impl;

import com.jingdianjichi.auth.infra.basic.entity.AuthUser;
import com.jingdianjichi.auth.infra.basic.mapper.AuthUserMapper;
import com.jingdianjichi.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 用户信息表(AuthUser)表服务实现类
 *
 * @author makejava
 * @since 2024-09-28 21:08:10
 */
@Service("authUserService")
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserMapper authUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthUser queryById(Long id) {
        return this.authUserMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUser insert(AuthUser authUser) {
        this.authUserMapper.insert(authUser);
        return authUser;
    }

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUser update(AuthUser authUser) {
        this.authUserMapper.update(authUser);
        return this.queryById(authUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserMapper.deleteById(id) > 0;
    }
}