package com.study.appapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.study.appapi.dao.mapper.UserMapper;
import com.study.appapi.domain.dto.User;
import com.study.appapi.domain.req.LoginReqVo;
import com.study.appapi.domain.req.RegistereReqVo;
import com.study.appapi.domain.resp.LoginRespVo;
import com.study.appapi.service.LoginService;
import com.study.appapi.util.CodeUtil;
import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;
import java.util.UUID;

/**
 * @ClassName : LoginServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 登录
     */
    @Override
    public Result login(LoginReqVo reqVo) {
        log.info("用户开始登录：{}", JSON.toJSONString(reqVo));
        //判断是何种方式登录
        if(reqVo.getType()==0){
            log.info("用户使用账号密码登录");
            // 使用账号名查询用户信息
            User user = userMapper.selectByAccount(reqVo.getAccount());
            if(Objects.isNull(user)){
                log.info("当前用户为查询到用户有效信息");
                return Result.resultFail(ResultStatus.NO_USERINFO);
            }
            //判断用户是否启用
            if(user.getStatus()==0){

                log.info("此用户已被禁用无法登录");
                return Result.resultFail(ResultStatus.USERINFO_DISABLE);
            }
            if(user.getDelFlag()==0){
                log.info("此用户已被删除");
                return Result.resultFail(ResultStatus.USERINFO_DELETE);
            }
            //判断用户密码是否相等
            // 对密码进行加密
            String password  = DigestUtils.md5DigestAsHex((reqVo.getPassword()+user.getSalt()).getBytes());
            //判断密码是否相等
            if(StringUtils.equals(user.getPassword(),password)){
                log.info("密码相等");
                //设置登录后访问接口的令牌
                LoginRespVo loginRespVo  = new LoginRespVo();
                BeanUtils.copyProperties(user,loginRespVo);
                //设置访问的令牌，并且将用户信息已令牌为key存储到Redis中
                String token = UUID.randomUUID().toString().replace("_","");

                loginRespVo.setToken(token);
                redisTemplate.opsForValue().set(token,loginRespVo);
                return Result.returnSuccess(loginRespVo);


            }else{
                log.info("密码不相等");
              return   Result.resultFail(ResultStatus.PASSWORD_ERROR);
            }


        }else{

          return Result.returnSuccess();
        }

    }


    @Override
    public Result sendCode(String phone) {
        log.info("手机号码注册账号：{}",JSON.toJSONString(phone));
        //判断此手机号码是否已经存在
        User user = userMapper.selectByPhone(phone);
        if(Objects.isNull(user)){
            return Result.resultFail(ResultStatus.USER_ISEXIST);
        }else {
            String code = CodeUtil.getCode();
            //TODO 发送验证码
            //将验证码存储在redis 中并且设置5分钟的过期时间
            redisTemplate.opsForValue().set(phone+"Re",code);
            return Result.returnSuccess();
        }
    }

    @Override
    public Result registere(RegistereReqVo registereReqVo) {
        //查询验证码是否已经发送验证码

        return null;
    }
}
