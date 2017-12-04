package com.meltwater.viperdemo.documents.interactor;

import com.meltwater.viperdemo.documents.DataManager.DocumentDataManager;
import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.DataManager.DocServiceApi;
import com.meltwater.viperdemo.documents.entity.DocumentModel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentListInteractor implements DocumentListContract.InteractorInput, DocumentListContract.DataManagerOutput {

    private DocumentListContract.InteractorOutput presenter;
    private DocumentDataManager dataManager;

    public DocumentListInteractor(DocumentListContract.InteractorOutput presenter) {
        this.presenter = presenter;
        dataManager = new DocumentDataManager(this);
    }

    @Override
    public void retrieveDocuments(HashMap<String, Object> query) {
        dataManager.retrieveDocuments(query);
    }

    @Override
    public void didRetrieveDocuments(List<DocumentModel> documents) {
        presenter.didRetrieveDocuments(documents);
    }

    @Override
    public void onError(String errorMsg) {
       // presenter.onError(errorMsg);
    }
}


