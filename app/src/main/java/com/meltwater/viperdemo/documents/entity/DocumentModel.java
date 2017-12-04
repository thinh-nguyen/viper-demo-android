package com.meltwater.viperdemo.documents.entity;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentModel {

    private String documentId;
    private String title;
    private String matchSentence;
    private String url;
    private Integer reach = 0;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMatchSentence() {
        return matchSentence;
    }

    public void setMatchSentence(String matchSentence) {
        this.matchSentence = matchSentence;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getReach() {
        return reach;
    }

    public void setReach(Integer reach) {
        this.reach = reach;
    }
}
