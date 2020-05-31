package com.project.voith.config;

import com.project.voith.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class WebpageSetup implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    ReaderService readerService;
    @Value("${webpage.url}")
    String url;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        readerService.fillWebpage(url);
    }

}
