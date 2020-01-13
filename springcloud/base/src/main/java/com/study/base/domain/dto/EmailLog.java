package com.study.base.domain.dto;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "w_email_log")
public class EmailLog {
    /**
     * 主键
     */
    private Long id;

    /**
     * 接受邮箱的地址
     */
    private String email;

    /**
     * 0:发送失败。1发送成功
     */
    private Byte status;

    /**
     * 发送时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取接受邮箱的地址
     *
     * @return email - 接受邮箱的地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置接受邮箱的地址
     *
     * @param email 接受邮箱的地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取0:发送失败。1发送成功
     *
     * @return status - 0:发送失败。1发送成功
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0:发送失败。1发送成功
     *
     * @param status 0:发送失败。1发送成功
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取发送时间
     *
     * @return create_time - 发送时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发送时间
     *
     * @param createTime 发送时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取发送内容
     *
     * @return content - 发送内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置发送内容
     *
     * @param content 发送内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}