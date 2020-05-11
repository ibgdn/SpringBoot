package com.ice.sessionshare;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 5.Spring Session 实现 Session 共享
 */
@RestController
public class SessionShareController {

    @Value("${server.port}")
    Integer port;

    @GetMapping(value = "/setSession")
    public String setSession(HttpSession session) {
        session.setAttribute("name", "session");
        return String.valueOf(port);
    }

    @GetMapping(value = "getSession")
    public String getSession(HttpSession session) {
        return (String) session.getAttribute("name") + port;
    }
}
