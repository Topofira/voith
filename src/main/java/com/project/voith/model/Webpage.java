package com.project.voith.model;

import java.util.HashMap;

public class Webpage extends Blurb {
    private HashMap<Header, Information> tableOfContents = new HashMap<>();

    public HashMap<Header, Information> getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(HashMap<Header, Information> tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public void addToContents(Header header, Information content) {
        tableOfContents.put(header, content);
    }
}
