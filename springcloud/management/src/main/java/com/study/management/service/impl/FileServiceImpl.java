package com.study.management.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.study.management.domain.config.ConfigValue;
import com.study.management.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : FileServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/9/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ConfigValue configValue;
    @Override
    public String upload(MultipartFile file) {


        try {
            OSS build = new OSSClientBuilder().build(configValue.endPoint, configValue.accessKeyId, configValue.accessKeySecret);


            if (build.doesBucketExist(configValue.bucketName)) {
                log.info("您已经创建Bucket：" + configValue.bucketName + "。");
            } else {
                log.info("您的Bucket不存在，创建Bucket：" + configValue.bucketName + "。");
                // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
                // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
                build.createBucket(configValue.bucketName);
            }
            // 上传文件

            String name = file.getOriginalFilename();

            log.info("上传文件的名称为：{}", name);
            build.putObject(configValue.bucketName, name, file.getInputStream());
            StringBuffer stringBuffer = new StringBuffer("https://wkt-wtt.oss-cn-hangzhou.aliyuncs.com/");
            stringBuffer.append(name);

            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    }

    @Override
    public List<String> uploads(MultipartFile[] files) {
        List<String> strings = new ArrayList<>();
        try {
            OSS build = new OSSClientBuilder().build(configValue.endPoint, configValue.accessKeyId, configValue.accessKeySecret);


            if (build.doesBucketExist(configValue.bucketName)) {
                log.info("您已经创建Bucket：" + configValue.bucketName + "。");
            } else {
                log.info("您的Bucket不存在，创建Bucket：" + configValue.bucketName + "。");
                // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
                // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
                build.createBucket(configValue.bucketName);
            }
            // 上传文件

            StringBuffer stringBuffer = null;

            for (MultipartFile file : files) {
                String name = file.getOriginalFilename();

                log.info("上传文件的名称为：{}", name);
                build.putObject(configValue.bucketName, name, file.getInputStream());
                stringBuffer = new StringBuffer("https://wkt-wtt.oss-cn-hangzhou.aliyuncs.com/");
                stringBuffer.append(name);
                strings.add(stringBuffer.toString());
            }



            return strings;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("出现错误");
        }
    }
}