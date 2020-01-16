package com.study.common.base;


import javax.naming.Name;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "请求页码不能为空")
    @Min(value = 1,message = "当前页数不得少于1")
    private Integer page ;

    /**
     * 请求页面条数
     */
    @NotNull(message = "分页参数不得为空")
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
