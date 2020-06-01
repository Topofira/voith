package com.project.voith.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

public class Section extends Blurb {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected ArrayList<Information> contents = new ArrayList<>();

    public ArrayList<Information> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Information> contents) {
        this.contents = contents;
    }

    public void addContent(Information information) {
        contents.add(information);
    }
}
