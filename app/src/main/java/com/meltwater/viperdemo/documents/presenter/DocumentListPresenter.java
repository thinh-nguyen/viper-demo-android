package com.meltwater.viperdemo.documents.presenter;


import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentModel;
import com.meltwater.viperdemo.documents.interactor.DocumentListInteractor;
import com.meltwater.viperdemo.documents.view.BaseViperView;

import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentListPresenter extends BasePresenter<BaseViperView> implements DocumentListContract.Presenter, DocumentListContract.InteractorOutput {

    private DocumentListInteractor interactor;

    public DocumentListPresenter() {
        interactor = new DocumentListInteractor();
    }

    @Override // DocumentListInteractorOutputProtocol
    public void didRetrieveDocuments(List<DocumentModel> documents) {

    }

    @Override // DocumentListPresenterProtocol
    public void presentDocuments() {

    }
}
