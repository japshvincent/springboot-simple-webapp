package com.simple.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Objects;

@Controller
public class PublicPageController {
    private final Logger logger = LoggerFactory.getLogger(PublicPageController.class);
    @RequestMapping(value = {"/", ""})
    public String blank(Principal principal) {
        if(Objects.nonNull(principal)) {
            logger.info(principal.getName());
            return "redirect:/index";
        } else {
            return "loginProviders";
        }
    }
}
