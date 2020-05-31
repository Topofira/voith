package com.project.voith.service;

import com.project.voith.model.Blurb;
import com.project.voith.model.Information;
import com.project.voith.model.Section;
import com.project.voith.model.Webpage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ReaderService {
    private Webpage webpage;

    public void fillWebpage(String url){
        try {
            webpage = new Webpage();
            Document doc = Jsoup.connect(url).get();
            webpage.setTitle(doc.title());
            webpage.setSummary(doc.selectFirst("p").text());
            fillTableOfContents(doc);
        } catch (IOException e) {

        }

    }

    private void fillTableOfContents(Document doc){
        Element tableOfContents = doc.selectFirst("ul");
        Elements mainSections = tableOfContents.select("li");
        for (Element element: mainSections) {
            String header = element.child(0).text();
            Information contentToAdd = fillContents(doc, element);
            webpage.addToContents(header,contentToAdd);
        }
    }

    private Information fillContents (Document doc, Element element){
        Information information;
        String title;
        if (element.select("ul") != null){
            title = element.child(0).text();
            information = new Section();
            for (Element subcontent : element.children().select("li")){
                ((Section)information).addContent(fillContents(doc, subcontent));
            }
        } else{
            title = element.text();
            information = new Blurb();
        }
        information.setSummary(fetchSummary(doc, element));
        information.setTitle(title);
        return information;
    }

    private String fetchSummary (Document doc, Element element) {
        String id = element.selectFirst("a").attr("href").substring(1);
        int index = doc.getElementById(id).parent().elementSiblingIndex();
        return doc.getElementsByIndexEquals(index+1).select("p").text();
    }

    public Webpage getWebpage () {
        return webpage;
    }


}
