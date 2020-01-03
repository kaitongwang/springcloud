package com.study.appapi.domain.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "w_user")
public class User {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 身份证号码
     */
    @Column(name = "card_id")
    private String cardId;

    /**
     * 账户
     */
    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户真实姓名
     */
    @Column(name = "true_name")
    private String trueName;

    /**
     * 用户电话号码
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 状态（0禁用，1启用）
     */
    private Byte status;

    /**
     * (0是删除。1是可用)
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;


}