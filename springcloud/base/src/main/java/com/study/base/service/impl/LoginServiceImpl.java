package com.study.base.service.impl;

import com.study.base.domain.dto.Leader;
import com.study.base.mapper.LeaderMapper;
import com.study.base.service.LoginService;
import com.study.base.web.LoginController;
import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import com.study.common.util.MD5Util;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.LoginReqVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : LoginServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class LoginServiceImpl  implements LoginService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LeaderMapper leaderMapper;
    @Override
    public Result login( LoginReqVo loginReqVo) {
        //按照账户查询用户
        log.info("用户使用账号密码登录");
        // 使用账号名查询用户信息
        Leader leader = leaderMapper.selectByAccount(loginReqVo.getAccount());
        if(Objects.isNull(leader)){
            log.info("当前用户为查询到用户有效信息");
            return Result.resultFail(ResultStatus.NO_USERINFO);
        }
        //判断用户是否启用
        if(leader.getStatus()==0){

            log.info("此用户已被禁用无法登录");
            return Result.resultFail(ResultStatus.USERINFO_DISABLE);
        }

        //判断用户密码是否相等
        // 对密码进行加密

        //判断密码是否相等
        if(MD5Util.MD5Equal(loginReqVo.getPassword(),leader.getSalt(),leader.getPassword())) {
            log.info("密码相等");
            //设置登录后访问接口的令牌
            CurrentUser loginRespVo = new CurrentUser();
            BeanUtils.copyProperties(leader, loginRespVo);
            //设置访问的令牌，并且将用户信息已令牌为key存储到Redis中
            String token = UUID.randomUUID().toString().replace("_", "");

            loginRespVo.setToken(token);
            redisTemplate.opsForValue().set(token, loginRespVo,24, TimeUnit.HOURS);
            return Result.returnSuccess(loginRespVo);

        }else {
            return Result.resultFail(ResultStatus.CODE_ISFALSE);

        }
    }

    @Override
    public Result<CurrentUser> check(String token) {
        Object o = redisTemplate.opsForValue().get(token);
        if(!Objects.isNull(o)){
            CurrentUser currentUser  = (CurrentUser)o;
            return Result.returnSuccess(currentUser);
        }else {
            return Result.resultFail(ResultStatus.LOGIN_NOUSER);
        }
    }

    @Override
    public Result exist(String token) {
        redisTemplate.expire(token,1,TimeUnit.SECONDS);
        return Result.returnSuccess();
    }
}
