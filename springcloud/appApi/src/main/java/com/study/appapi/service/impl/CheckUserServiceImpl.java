package com.study.appapi.service.impl;

import com.study.appapi.domain.dto.User;
import com.study.appapi.domain.resp.LoginRespVo;
import com.study.appapi.service.CheckUserService;
import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName : CheckUserServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class CheckUserServiceImpl implements CheckUserService {
    @Autowired

    private  RedisTemplate redisTemplate;

    @Override
    public Result<User> checkUser(String token) {
        log.info("查询用户是否具登录条件");
        Object o = redisTemplate.opsForValue().get(token);

      if (Objects.isNull(o)){
          //未查询用户信息，说明登录已经失效
          return  Result.resultFail(ResultStatus.LOGIN_NO_USER);

      }else{
          LoginRespVo loginRespVo = (LoginRespVo)o;
          User user = new User();
          BeanUtils.copyProperties(loginRespVo,user);
          return  Result.returnSuccess(user);


      }

    }
}
