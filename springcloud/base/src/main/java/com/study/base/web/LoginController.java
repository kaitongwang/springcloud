package com.study.base.web;

import com.study.base.service.LoginService;
import com.study.common.base.Result;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.LoginReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Result login(@RequestBody LoginReqVo LoginReqVo){
     return     loginService.login(LoginReqVo);
    }


    @PostMapping("/check")
    public Result<CurrentUser> check(@RequestParam("token") String token){
        return     loginService.check(token);
    }


    @PostMapping("/exist")
    public Result exist(@RequestParam("token") String token){
        return     loginService.exist(token);
    }
}
