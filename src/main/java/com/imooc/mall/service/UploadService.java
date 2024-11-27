package com.imooc.mall.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {
    void createFile(MultipartFile multipartFile, File fileDirectory, File destFile);

    String uploadFile(MultipartFile multipartFile);

    String getNewFileName(MultipartFile multipartFile);
}
