package com.study.appapi.domain.req;

import lombok.Data;

/**
 * @ClassName : LoginReqVo
 * @description : 登录请求vo
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class LoginReqVo {

    /**
     * 账户或者手机号
     */
    private String  account;

    /**
     * 密码或者验证码
     */
    private String password;


    /**
     * 类型 0是账户登录 1是短信验证码登录
     */
    private Integer type;

}
