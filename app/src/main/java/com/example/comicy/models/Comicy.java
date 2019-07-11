package com.example.comicy.models;

public class Comicy {
    private String mId;
    private String mTitle;
    private String mIssueNumber;
    private String mDescription;
    private String mFormat;
    private String mModified;
    private String mThumbnail;
    private String mPagecount;


    public Comicy(String id, String title, String issueNumber,
                  String description, String format, String modified,
                  String thumbnail, String pagecount) {
        this.mId = id;
        this.mTitle = title;
        this.mIssueNumber = issueNumber;
        this.mDescription = description;
        this.mFormat = format;
        this.mModified = modified;
        this.mThumbnail = thumbnail;
        this.mPagecount = pagecount;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getIssueNumber() {
        return mIssueNumber;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getFormat() {
        return mFormat;
    }

    public String getModified() {
        return mModified;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getPagecount() {
        return mPagecount;
    }

}
