package com.meltwater.viperdemo.documents.presenter;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentModel;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;
import com.meltwater.viperdemo.documents.interactor.DocumentListInteractor;
import com.meltwater.viperdemo.documents.router.DocumentListRouter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thinhnguyen on 12/3/17.
 * Demp
 */

public class DocumentListPresenter implements DocumentListContract.Presenter, DocumentListContract.InteractorOutput {

    private DocumentListContract.View view;
    private DocumentListContract.InteractorInput interactor;
    private DocumentListContract.Router router;

    private List<DocumentUIModel> documentUIModelList = new ArrayList<>();

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
        interactor.retrieveDocuments(getDummyQueryMap());
    }

    private HashMap<String, Object> getDummyQueryMap() {
        HashMap<String, Object> map = new HashMap<>(0);

        map.put("dupDocsCapSize", new Integer(5));
        map.put("country", "us");
        map.put("pageSize", new Integer(20));
        map.put("groupFrom", new Integer(0));
        map.put("dateEnd", "2017-11-07T20:00:19.028Z");
        map.put("sortOrder", "DESC");
        map.put("groupOption", "close");
        map.put("dateStart", "2017-11-02T19:01:49.000Z");
        map.put("agents", "2102541");
        map.put("page", new Integer(0));
        map.put("sortField", "date");
        map.put("additionalFields", "images");

        return map;
    }
}
