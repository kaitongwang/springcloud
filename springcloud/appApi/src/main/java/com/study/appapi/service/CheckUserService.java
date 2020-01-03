package com.study.appapi.service;

import com.study.appapi.domain.dto.User;
import com.study.common.base.Result;

/**
 * @ClassName : CheckUserService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface CheckUserService {

    Result<User>    checkUser(String token);
}
