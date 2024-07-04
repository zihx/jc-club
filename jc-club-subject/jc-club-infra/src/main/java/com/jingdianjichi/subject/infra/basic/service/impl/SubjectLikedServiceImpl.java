package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.infra.basic.entity.SubjectLiked;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectLikedMapper;
import com.jingdianjichi.subject.infra.basic.service.SubjectLikedService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 题目点赞表(SubjectLiked)表服务实现类
 *
 * @author makejava
 * @since 2024-07-03 21:47:27
 */
@Service("subjectLikedService")
public class SubjectLikedServiceImpl implements SubjectLikedService {
    @Resource
    private SubjectLikedMapper subjectLikedMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLiked queryById(Long id) {
        return this.subjectLikedMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked insert(SubjectLiked subjectLiked) {
        this.subjectLikedMapper.insert(subjectLiked);
        return subjectLiked;
    }

    /**
     * 修改数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked update(SubjectLiked subjectLiked) {
        this.subjectLikedMapper.update(subjectLiked);
        return this.queryById(subjectLiked.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLikedMapper.deleteById(id) > 0;
    }
}
