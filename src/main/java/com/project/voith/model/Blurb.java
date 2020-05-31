package com.project.voith.model;

import java.io.Serializable;

public class Blurb implements Serializable, Information {
    private String title;
    private String summary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
