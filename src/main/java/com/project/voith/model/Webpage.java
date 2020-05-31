package com.project.voith.model;

import java.util.HashMap;

public class Webpage extends Section {
    private HashMap<String, Information> tableOfContents = new HashMap<>();

    public HashMap<String, Information> getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(HashMap<String, Information> tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public void addToContents(String header, Information content) {
        tableOfContents.put(header, content);
        contents.add(content);
    }
}
