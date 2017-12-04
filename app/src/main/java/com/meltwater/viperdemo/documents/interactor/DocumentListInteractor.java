package com.meltwater.viperdemo.documents.interactor;

import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocQuery;
import com.meltwater.viperdemo.documents.entity.DocumentModel;

import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentListInteractor implements DocumentListContract.InteractorInput, DocumentListContract.DataManagerOutput {

    DocumentListContract.InteractorOutput presenter;

    @Override
    public void retrieveDocuments(DocQuery query) {

    }

    @Override
    public void didRetrieveDocuments(List<DocumentModel> documents) {

    }

    @Override
    public void onError(String errorMsg) {

    }
}


