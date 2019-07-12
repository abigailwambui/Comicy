package com.example.comicy.models;


import org.parceler.Parcel;

@Parcel
public class Comicy {
    private String id;
    private String title;
    private String issueNumber;
    private String description;
    private String format;
    private String modified;
    private String thumbnail;
    private String pagecount;
    private String pushId;


    public Comicy() {}

    public Comicy(String id, String title, String issueNumber,
                  String description, String format, String modified,
                  String thumbnail, String pagecount) {
        this.id = id;
        this.title = title;
        this.issueNumber = issueNumber;
        this.description = description;
        this.format = format;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.pagecount = pagecount;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    public String getModified() {
        return modified;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getPagecount() {
        return pagecount;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
