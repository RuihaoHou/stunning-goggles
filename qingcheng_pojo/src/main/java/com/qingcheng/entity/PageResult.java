package com.qingcheng.entity;

import com.qingcheng.pojo.goods.Brand;

import java.io.Serializable;
import java.util.List;

/**
 * @author houruihao
 * @date 2020-08-01 18:24
 * @description
 */
public class PageResult<T> implements Serializable {

    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
