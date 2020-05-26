package com.ice.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 14.Spring Security 结合 OAuth2
 */
@RestController
public class Oauth2Controller {

    @GetMapping("/oauth2")
    public String oauth2(){
        return "Oauth2";
    }

    @GetMapping("/oauth2/admin")
    public String admin(){
        return "Oauth2 admin";
    }

    @GetMapping("/oauth2/user")
    public String user(){
        return "Oauth2 user";
    }
}
