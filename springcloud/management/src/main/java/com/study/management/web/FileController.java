package com.study.management.web;

import com.study.management.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName : FileController
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/9/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RestController
@RequestMapping("/wkt/file")
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public String upload(MultipartFile file){
        return  fileService.upload(file);
    }


}