package com.study.base.domain.dto.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "w_email")
public class Email {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 邮箱id
     */
    private String email;

    /**
     * 状态，0是禁用，1是启用，2是删除
     */
    private Byte status;

    /**
     * 创建人

     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     *  更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取邮箱id
     *
     * @return email - 邮箱id
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱id
     *
     * @param email 邮箱id
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取状态，0是禁用，1是启用，2是删除
     *
     * @return status - 状态，0是禁用，1是启用，2是删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态，0是禁用，1是启用，2是删除
     *
     * @param status 状态，0是禁用，1是启用，2是删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建人

     *
     * @return create_by - 创建人

     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人

     *
     * @param createBy 创建人

     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新人
     *
     * @return update_by - 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取 更新时间
     *
     * @return update_time -  更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTime  更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}