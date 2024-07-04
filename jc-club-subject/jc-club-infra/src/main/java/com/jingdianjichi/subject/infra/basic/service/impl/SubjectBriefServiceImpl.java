package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectBriefMapper;
import com.jingdianjichi.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 简答题(SubjectBrief)表服务实现类
 *
 * @author makejava
 * @since 2024-07-03 21:47:23
 */
@Service("subjectBriefService")
public class SubjectBriefServiceImpl implements SubjectBriefService {
    @Resource
    private SubjectBriefMapper subjectBriefMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectBrief queryById(Long id) {
        return this.subjectBriefMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief insert(SubjectBrief subjectBrief) {
        this.subjectBriefMapper.insert(subjectBrief);
        return subjectBrief;
    }

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief update(SubjectBrief subjectBrief) {
        this.subjectBriefMapper.update(subjectBrief);
        return this.queryById(subjectBrief.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectBriefMapper.deleteById(id) > 0;
    }
}
