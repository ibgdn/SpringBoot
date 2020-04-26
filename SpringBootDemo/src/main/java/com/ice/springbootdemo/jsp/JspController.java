package com.ice.springbootdemo.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * jsp 控制层
 */
@Controller
public class JspController {
    @GetMapping("/jsp")
    public String jsp(Model model, String name) {
        model.addAttribute("name", name);
        return "jsp";
    }
}
