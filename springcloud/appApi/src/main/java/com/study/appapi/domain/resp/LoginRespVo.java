package com.study.appapi.domain.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @ClassName : LoginRespVo
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class LoginRespVo {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 身份证号码
     */
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
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 访问后台的令牌
     */
    private String token;

}
