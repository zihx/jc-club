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
    private Integer pageNo;

    private Integer pageSize;

    private Integer total = 0;

    private Integer totalPages = 0;

    private List<T> result = Collections.emptyList();

    private Integer start = 0;

    private Integer end = 0;

    public void setRecords(List<T> result) {
        this.result = result;
        if (result != null && !result.isEmpty()) {
            setTotal(result.size());
        }
    }

    public void setTotal(Integer total) {
        this.total = total;
        if (this.pageSize > 0) {
            this.totalPages = total / this.pageSize + (total % this.pageSize == 0 ? 0 : 1);
        } else {
            this.totalPages = 0;
        }
        this.start = (this.pageSize > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
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
