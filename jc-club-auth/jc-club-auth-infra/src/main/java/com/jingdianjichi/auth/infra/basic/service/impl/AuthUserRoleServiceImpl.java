package com.jingdianjichi.auth.infra.basic.service.impl;

import com.jingdianjichi.auth.infra.basic.entity.AuthUserRole;
import com.jingdianjichi.auth.infra.basic.mapper.AuthUserRoleMapper;
import com.jingdianjichi.auth.infra.basic.service.AuthUserRoleService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 用户角色表(AuthUserRole)表服务实现类
 *
 * @author makejava
 * @since 2024-09-28 21:08:10
 */
@Service("authUserRoleService")
public class AuthUserRoleServiceImpl implements AuthUserRoleService {
    @Resource
    private AuthUserRoleMapper authUserRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthUserRole queryById(Long id) {
        return this.authUserRoleMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param authUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUserRole insert(AuthUserRole authUserRole) {
        this.authUserRoleMapper.insert(authUserRole);
        return authUserRole;
    }

    /**
     * 修改数据
     *
     * @param authUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUserRole update(AuthUserRole authUserRole) {
        this.authUserRoleMapper.update(authUserRole);
        return this.queryById(authUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserRoleMapper.deleteById(id) > 0;
    }
}
