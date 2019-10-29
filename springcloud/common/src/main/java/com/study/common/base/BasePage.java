package com.study.common.base;



import java.util.List;

/**
 * 描述: 分页返回实体
 *
 * @Author;wangkaitong
 * @Date;2019/7/22
 * @Version;1.0
 * @Senice;1.0
 */
public class BasePage<T> {

    /**
     * 总记录数
     */
    private Long totalCount;

    /**
     * 当前页
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 数据
     */
    private List<T> data;

    public BasePage() {
    }


    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}