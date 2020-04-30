package com.ice.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 6.Spring Boot文件上传 "/upload"
 * 8.Spring Boot 多文件上传 "/uploads"
 */
@RestController
public class FileUploadController {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yy/MM/dd/");
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        // 形参 file 需与前端名称相同
        // 旧文件名
        String oldFileName = file.getOriginalFilename();
        // 创建新文件路径及文件名
        String format = simpleDateFormat.format(new Date());
        String filePath = request.getServletContext().getRealPath("/img") + format;
        File newFilePath = new File(filePath);
        if (!newFilePath.exists()) {
            newFilePath.mkdirs();
        }
        String newFileName = UUID.randomUUID().toString() + oldFileName.substring(oldFileName.lastIndexOf("."));

        try {
            file.transferTo(new File(newFilePath, newFileName));
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img" + format + newFileName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @PostMapping(value = "/uploads")
    public String uploads(MultipartFile[] files, HttpServletRequest request) {
        String format = simpleDateFormat.format(new Date());
        String filePath = request.getServletContext().getRealPath("/img") + format;
        File newFilePath = new File(filePath);
        if (!newFilePath.exists()) {
            newFilePath.mkdirs();
        }
        for (MultipartFile file : files) {
            String oldFileName = file.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString() + oldFileName.substring(oldFileName.lastIndexOf("."));
            try {
                file.transferTo(new File(newFilePath, newFileName));
                System.out.println("url: " + request.getScheme() + "://"
                        + request.getServerName() + ":" + request.getServerPort() + "/img" + format + newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "success";
    }
}
