package com.study.base.task;

import com.study.base.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ClassName : Task
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/20
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Configuration
public class Task {


    @Autowired
    private TaskService taskService;



    @Scheduled(cron = "0 30 7 1/1 * ? ")
    public void test(){
        taskService.sendEmail();
    }
}
