package com.study.common.vo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName : CurrentUser
 * @description : 当前线程保存用户信息
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class CurrentUser  {
    /**
     * 主键
     */
    private Long id;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 账户
     */
    private String account;


    /**
     * 邮件
     */
    private String email;

    /**
     * 电话
     */
    private String phone;


    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
