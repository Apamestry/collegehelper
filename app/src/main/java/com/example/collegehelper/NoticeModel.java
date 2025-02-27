package com.example.collegehelper;

public class NoticeModel {
    private String title;
    private String link;

    public NoticeModel(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}

