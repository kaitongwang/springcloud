package com.study.management;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : BaseApplication
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/29
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class,args);
    }
}
