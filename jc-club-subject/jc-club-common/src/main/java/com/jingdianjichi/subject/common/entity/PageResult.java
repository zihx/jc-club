package com.jingdianjichi.subject.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: PageResult
 * Package: com.jingdianjichi.subject.common.entity
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 22:37
 * @Version 1.0
 */
@Data
public class PageResult<T> implements Serializable {

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Integer total = 0;

    /**
     * 总页数
     */
    private Integer totalPages = 0;

    /**
     * 该页的数据
     */
    private List<T> result = Collections.emptyList();

    /**
     * 该页的起始序号
     */
    private Integer start = 0;

    /**
     * 该页的结束序号
     */
    private Integer end = 0;

    public void setRecords(List<T> result) {
        this.result = result;
        // if (result != null && !result.isEmpty()) {
        //     setTotal(result.size());
        // }
    }

    public void setTotal(Integer total) {
        this.total = total;
        if (this.pageSize > 0) {
            this.totalPages = total / this.pageSize + (total % this.pageSize == 0 ? 0 : 1);
        } else {
            this.totalPages = 0;
        }

        this.start = (this.pageNo - 1) * this.pageSize + 1;
        this.end = this.pageNo * this.pageSize;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo == null || pageNo < 1) {
            this.pageNo = 1;
        }
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            this.pageSize = 20;
        }
        this.pageSize = pageSize;
    }
}
