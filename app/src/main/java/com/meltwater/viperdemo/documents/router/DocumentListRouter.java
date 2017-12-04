package com.meltwater.viperdemo.documents.router;

import android.support.v7.app.AppCompatActivity;

import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;
import com.meltwater.viperdemo.documents.interactor.DocumentListInteractor;
import com.meltwater.viperdemo.documents.presenter.DocumentListPresenter;
import com.meltwater.viperdemo.documents.view.DocumentListActivity;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentListRouter implements DocumentListContract.Router {

    private AppCompatActivity view;

    public DocumentListRouter(AppCompatActivity view) {
        this.view = view;
    }

    @Override
    public void routeToDocumentScreen(DocumentUIModel documentUIModel) {

    }
}
