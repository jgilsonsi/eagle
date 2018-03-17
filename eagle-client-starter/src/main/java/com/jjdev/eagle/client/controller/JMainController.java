package com.jjdev.eagle.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jgilson
 */
@Controller
public class JMainController {

    @GetMapping(value = "/")
    public String redirect() {
        return "redirect:/web/index.html";
    }

}
