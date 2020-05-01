package com.ice.requestparameter;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 12.@ControllerAdvice 请求参数预处理
 */
@ControllerAdvice
public class RequestParameterControllerAdvice {
    /**
     * 请求参数带 book. 前缀，都会被绑定到 Book 对象上。
     *
     * @param webDataBinder
     */
    @InitBinder("book")
    public void initBoot(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("book.");
    }

    /**
     * 请求参数带 author. 前缀，都会被绑定到 Author 对象上。
     *
     * @param webDataBinder
     */
    @InitBinder("author")
    public void initAuthor(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("author.");
    }
}
