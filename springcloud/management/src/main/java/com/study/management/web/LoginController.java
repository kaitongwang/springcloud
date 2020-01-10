package com.study.management.web;

import com.study.common.base.Result;
import com.study.common.vo.base.LoginReqVo;
import com.study.management.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : LoginController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;
    @PostMapping("/login/login")
    public Result login(@RequestBody LoginReqVo LoginReqVo){
     return     loginService.login(LoginReqVo);
    }

    @PostMapping("/wkt/login/exist")
    public Result exist(){
         return loginService.exist();
    }

}
