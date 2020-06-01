package com.project.voith.model;

import java.io.Serializable;

public class Header implements Serializable {
    public Header (String header) {
        int spaceIndex = header.indexOf(' ');
        this.id = header.substring(0, spaceIndex);
        this.title = header.substring(spaceIndex+1);
    }

    public Header(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Header FromId(String id){
        return new Header(id,null);
    }

    public static Header FromTitle(String title){
        return new Header(null,title);
    }
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Header) {
            Header h = (Header)o;
            if(h!= null){
                if(h.getId() != null && h.getId().equals(id)){
                    return true;
                }
                if(h.getTitle() != null && h.getTitle().equals(title)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s",id, title);
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id.toString());
    }
}
