package com.study.appapi.web;

import com.study.appapi.domain.req.LoginReqVo;
import com.study.appapi.domain.req.RegistereReqVo;
import com.study.appapi.service.LoginService;
import com.study.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : LoginController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RequestMapping("/nologin")
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public Result login(@RequestBody LoginReqVo reqVo){

        return  loginService.login(reqVo);
    }
    @PostMapping("/loginSendCode")
    public Result loginSendCode(@RequestParam("phone")String phone){

        return  loginService.loginSendCode(phone);
    }

    /**
     * 注册发送验证码
     * @return
     */
    @GetMapping("sendCode")
    public Result sendCode(@RequestParam("phone")String phone){
      return   loginService.sendCode(phone);
    }

    @PostMapping("registere")
    public Result registere(@RequestBody RegistereReqVo registereReqVo){
        return loginService.registere(registereReqVo);
    }
}
