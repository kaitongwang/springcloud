package com.study.jedis;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : JedisApplication
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class JedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(JedisApplication.class,args);

    }
}
