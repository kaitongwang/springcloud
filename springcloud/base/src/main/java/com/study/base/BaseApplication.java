package com.study.base;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName : BaseApplication
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/29
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@EnableScheduling
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.study.base.mapper")
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }
}
