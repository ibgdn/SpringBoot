package com.ice.fileupload;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 10.@ControllerAdvice 处理全局异常
 */
@ControllerAdvice
public class UploadException {
    /**
     * 单纯返回 "上传文件超过 1 KB。" 到页面
     *
     * @param e
     * @param response
     * @throws IOException
     */
/*
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse response) throws IOException {
        // 解决中文乱码问题
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.print("上传文件超过 1 KB。");
        writer.flush();
        writer.close();
    }
*/

    /**
     * 配置 thymeleaf 页面（resources/templates/uploadError.html）展示错误文字
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e) {
        ModelAndView modelAndView = new ModelAndView("uploadError");
        modelAndView.addObject("maxUploadError", "上传文件超过 1 KB。");
        return modelAndView;
    }
}
