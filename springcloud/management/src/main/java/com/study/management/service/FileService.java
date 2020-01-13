package com.study.management.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName : FileService
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/9/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright :
 */
public interface FileService {

    String upload(MultipartFile file);


    List<String> uploads( MultipartFile[] files);
}