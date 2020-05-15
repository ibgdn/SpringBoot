package com.ice.hotdeployment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1.Devtools 简介
 */
@RestController
public class HotDeploymentController {
    @GetMapping("/hotDeployment")
    public String hotDeployment() {
        return "Hot Deployment.";
    }
}
