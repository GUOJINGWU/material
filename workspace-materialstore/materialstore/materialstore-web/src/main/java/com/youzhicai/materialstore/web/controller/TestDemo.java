package com.youzhicai.materialstore.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youzhicai.materialstore.web.util.ConfigUtil;

@Controller
@RequestMapping("test")
public class TestDemo {

    @RequestMapping("/index")
    public String index(Model model) {
    	String value = ConfigUtil.getValue("currentProjectURL");
    	System.err.println(value);
        model.addAttribute("currentProjectURL", value);
        return "default/demo";
    }
}
