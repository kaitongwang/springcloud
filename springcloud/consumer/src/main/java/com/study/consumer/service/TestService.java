package com.study.consumer.service;

import com.study.common.result.Result;
import com.study.common.vo.test.User;

/**
 * @ClassName : TestService
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface TestService {

    Result<User> get();
}
