package com.study.common.base;


/**
 * 描述: 请求分页实体
 *
 * @Author;wangkaitong
 * @Date;2019/7/18
 * @Version;1.0
 * @Senice;1.0
 */
public class ReqPage {

    /**
     *请求页码
     */
    private Integer page ;

    /**
     * 请求页面条数
     */
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
