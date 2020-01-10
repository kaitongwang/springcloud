package com.study.management.web;


import com.study.management.domain.dto.Leader;
import com.study.management.domain.request.LeaderListReqVo;
import com.study.management.service.LeaderService;
import com.study.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : LeaderController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/8
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RequestMapping("/wkt/leader")
@RestController
public class LeaderController {


    @Autowired
    private LeaderService leaderService;

    @PostMapping("/getList")
    public Result getList(@RequestBody LeaderListReqVo leaderListReqVo){
        return leaderService.getList(leaderListReqVo);
    }

    @PostMapping ("add")
    public Result add(@RequestBody Leader leader){
        return  leaderService.add(leader);
    }
}
