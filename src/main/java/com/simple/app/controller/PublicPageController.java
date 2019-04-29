package com.simple.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicPageController {
    @RequestMapping(value = {"/", ""})
    public String blank() {
        return "loginProviders";
    }

    @RequestMapping(value = {"/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/index_jsp")
    public String indexJsp() {
        return "/index";
    }
}
