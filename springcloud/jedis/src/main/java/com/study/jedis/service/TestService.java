package com.study.jedis.service;

import com.study.common.base.Result;
import com.study.jedis.domain.vo.User;

/**
 * @ClassName : TestService
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface TestService {

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    Result addUser(User user);


    /**
     * 获取用户信息名称
     * @param userName
     * @return
     */
    Result getUser(String userName);
}
