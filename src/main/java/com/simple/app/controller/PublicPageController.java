package com.simple.app.controller;

import com.simple.app.config.interceptor.TestInterceptor;
import com.simple.app.test.scope.DefaultScoped;
import com.simple.app.test.scope.RequestScoped;
import com.simple.app.test.scope.SessionScoped;
import com.simple.app.test.scope.SingletonScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicPageController {
    private static Logger LOG = LoggerFactory.getLogger(TestInterceptor.class);

    @Autowired
    private DefaultScoped defaultScoped;
    @Autowired
    private RequestScoped requestScoped;
    @Autowired
    private SessionScoped sessionScoped;
    @Autowired
    private SingletonScoped singletonScoped;

    @RequestMapping(value = {"","/", "/index"})
    public String index(Model model) {
        LOG.info("### In Controller request mapping");

        model.addAttribute("defaultTestVal", defaultScoped.getValue());
        model.addAttribute("requestTestVal", requestScoped.getValue());
        model.addAttribute("sessionTestVal", sessionScoped.getValue());
        model.addAttribute("singletonTestVal", singletonScoped.getValue());
        return "index";
    }
}
