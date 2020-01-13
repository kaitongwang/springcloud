package com.study.base.web;

import com.study.base.service.HomeService;
import com.study.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : HomeController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/13
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/get")
    public Result getHomePicture() {

        return homeService.getHomePicture();
    }


}
