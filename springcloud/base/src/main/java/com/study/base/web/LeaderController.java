package com.study.base.web;

import com.study.base.domain.dto.Leader;
import com.study.base.domain.request.LeaderListReqVo;
import com.study.base.service.LeaderService;
import com.study.base.service.TaskService;
import com.study.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : LeaderController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/8
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RequestMapping("/leader")
@RestController
public class LeaderController {


    @Autowired
    private LeaderService leaderService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/getList")
    public Result getList(@RequestBody LeaderListReqVo leaderListReqVo){


        return leaderService.getList(leaderListReqVo);
    }

    @PostMapping ("add")
    public Result add(@RequestBody Leader leader){
        return  leaderService.add(leader);
    }

    @GetMapping("/send")
    public Result send (){
        taskService.sendEmail();
        return Result.returnSuccess();
    }
}
