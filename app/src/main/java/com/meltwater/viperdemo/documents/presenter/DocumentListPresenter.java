package com.meltwater.viperdemo.documents.presenter;

import android.provider.DocumentsContract;

import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentModel;

import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentListPresenter implements DocumentListContract.Presenter, DocumentListContract.InteractorOutput {

    DocumentListContract.View view;
    DocumentListContract.InteractorInput interactor;
    DocumentListContract.Router router;

    public DocumentListPresenter(DocumentListContract.View view, DocumentListContract.InteractorInput interactor,
                                 DocumentListContract.Router router ) {

        this.view = view;
        this.interactor = interactor;
        this.router = router;

    }

    @Override // DocumentListInteractorOutputProtocol
    public void didRetrieveDocuments(List<DocumentModel> documents) {

    }

    @Override // DocumentListPresenterProtocol
    public void presentDocuments() {

    }
}
