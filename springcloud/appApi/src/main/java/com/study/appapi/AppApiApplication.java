package com.study.appapi;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName : AppApiApplication
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
@EnableScheduling
@MapperScan("com.study.appapi.dao.mapper")
public class AppApiApplication {

    public static void main(String[] args) {
        System.out.println("------------------------项目正在启动------------------------");
        SpringApplication.run(AppApiApplication.class,args);
        System.out.println("------------------------项目启动完成------------------------");
    }
}
