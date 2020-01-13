package com.study.management.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ConfigValue
 * @description : 读取配置文件的的值
 * @Author : wangkaitong
 * @Date : 2019/9/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright :
 */
@Component
public class ConfigValue {

//    aliyun:
//    oss:
//    endPoint: http://oss-cn-hangzhou.aliyuncs.com
//    accessKeyId: LTAIOhuGwfpXp9J2
//    accessKeySecret: Fib7e89aT3a88O4sr241gPhhr7q3MG
//    bucketName: wkt-wtt
    @Value("${aliyun.oss.endPoint}")
    public String endPoint;

    @Value("${aliyun.oss.accessKeyId}")
    public String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    public String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    public String bucketName;
}