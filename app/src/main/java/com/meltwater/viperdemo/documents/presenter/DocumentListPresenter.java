package com.meltwater.viperdemo.documents.presenter;

import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentModel;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;
import com.meltwater.viperdemo.documents.interactor.DocumentListInteractor;
import com.meltwater.viperdemo.documents.router.DocumentListRouter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentListPresenter implements DocumentListContract.Presenter, DocumentListContract.InteractorOutput {

    DocumentListContract.View view;
    DocumentListContract.InteractorInput interactor;
    DocumentListContract.Router router;

    List<DocumentUIModel> documentUIModelList = new ArrayList<>();

    public DocumentListPresenter(DocumentListContract.View view) {
        this.view = view;
        this.interactor = new DocumentListInteractor(this);
        this.router = new DocumentListRouter((AppCompatActivity)view);
    }

    @Override // DocumentListInteractorOutputProtocol
    public void didRetrieveDocuments(List<DocumentModel> documents) {
        Log.d("Presenter", "didRetrieveDocuments " + documents.size());
        for (DocumentModel rawDoc : documents) {
            documentUIModelList.add( new DocumentUIModel(rawDoc));
        }
        view.showDocuments(documentUIModelList);
    }

    @Override // DocumentListPresenterProtocol
    public void presentDocuments() {
        /* Hard code the Query for demo */
        interactor.retrieveDocuments(null);
    }
}
