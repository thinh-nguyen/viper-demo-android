package com.meltwater.viperdemo.documents.entity;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentUIModel {

    private String displayTitle;
    private String displayMatchSentence;
    private String displayUrl;

    public DocumentUIModel( DocumentModel rawDocument) {

        displayTitle = rawDocument.getTitle();
        displayMatchSentence = rawDocument.getMatchSentence();
        displayUrl = rawDocument.getUrl();

    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getDisplayMatchSentence() {
        return displayMatchSentence;
    }

    public void setDisplayMatchSentence(String displayMatchSentence) {
        this.displayMatchSentence = displayMatchSentence;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }
}
