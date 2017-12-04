package com.meltwater.viperdemo.documents.entity;

import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentsPage {

    private Integer count;
    private List<DocumentModel> documents;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<DocumentModel> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentModel> documents) {
        this.documents = documents;
    }

    //    public DocumentModel[] getDocuments() {
//        return documents;
//    }
//
//    public void setDocuments(DocumentModel[] documents) {
//        this.documents = documents;
//    }
}
