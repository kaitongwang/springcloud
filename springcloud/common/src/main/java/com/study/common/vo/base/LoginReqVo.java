package com.study.common.vo.base;

import lombok.Data;

/**
 * @ClassName : LoginReqVo
 * @description : 登录请求实体
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class LoginReqVo {

    private String account;

    private String password;
}
