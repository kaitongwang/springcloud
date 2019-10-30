package com.study.jedis.service.impl;

import com.study.common.base.Result;
import com.study.jedis.domain.vo.User;
import com.study.jedis.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName : TestServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result addUser(User user) {
        log.info("添加用户信息，{}",user);
        redisTemplate.opsForValue().set(user.getName(),user);
        return Result.returnSuccess();
    }

    @Override
    public Result getUser(String userName) {
        log.info("获取用户信息的主键为：{}",userName);
         User user  =(User) redisTemplate.opsForValue().get(userName);
        return Result.returnSuccess(user);
    }
}
