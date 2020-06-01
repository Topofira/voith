package com.project.voith.controller;

import com.project.voith.model.Information;
import com.project.voith.model.Webpage;
import com.project.voith.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path="/contents")
    @ResponseBody
    public List<String> getTableOfContents () {
        return readerService.getTableOfContents();
    }

    @GetMapping(path="/contents/{contentId}")
    @ResponseBody
    public ResponseEntity getInformation(@PathVariable String contentId) {
        if(contentId.matches("\\d(\\.\\d)*")){
            Optional<Information> information = readerService.getContentById(contentId);
            if (information.isPresent()) {
                return new ResponseEntity(information, HttpStatus.OK);
            } else{
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity("Content id must be in format #.#", HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping(path="/getAllContents")
//    @ResponseBody
//    public ArrayList<Information> getContents () {
//        return readerService.getAllContents();
//    }
}
