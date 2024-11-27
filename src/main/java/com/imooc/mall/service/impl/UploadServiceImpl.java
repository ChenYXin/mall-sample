package com.imooc.mall.service.impl;

import com.imooc.mall.common.Constant;
import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.exception.ImoocMallExceptionEnum;
import com.imooc.mall.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
    @Value("${file.upload.uri}")
    String uri;

    @Override
    public void createFile(MultipartFile multipartFile, File fileDirectory, File destFile) {
        if (!fileDirectory.exists()) {
            if (!fileDirectory.mkdirs()) {
                throw new ImoocMallException(ImoocMallExceptionEnum.MKDIR_FAILED);
            }
        }
        try {
            multipartFile.transferTo(destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String newFileName = getNewFileName(multipartFile);
        //创建文件
        File fileDirectory = new File(Constant.FILE_UPLOAD_DIR);
        File destFile = new File(Constant.FILE_UPLOAD_DIR + newFileName);

        createFile(multipartFile, fileDirectory, destFile);
        String address = uri;
        return "http://" + address + "/images/" + newFileName;
    }

    @Override
    public String getNewFileName(MultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //生成UUID
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString() + suffixName;
        return newFileName;
    }
}
