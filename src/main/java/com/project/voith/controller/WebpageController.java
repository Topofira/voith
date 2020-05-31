package com.project.voith.controller;

import com.project.voith.model.Webpage;
import com.project.voith.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/main")
public class WebpageController {
    @Autowired
    ReaderService readerService;

    @GetMapping
    @ResponseBody
    public Webpage getWebpage () {
        return readerService.getWebpage();
    }
}
