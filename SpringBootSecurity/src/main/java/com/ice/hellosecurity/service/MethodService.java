package com.ice.hellosecurity.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * 9.方法安全
 */
@Service
public class MethodService {
    @PreAuthorize("hasRole('admin')")
    public String adminMehtod() {
        return "admin method";
    }

    @Secured("ROLE_user")
    public String userMethod() {
        return "user method";
    }

    @PreAuthorize("hasAnyRole('admin','user')")
    public String anyRoleMethod() {
        return "any role method";
    }
}
