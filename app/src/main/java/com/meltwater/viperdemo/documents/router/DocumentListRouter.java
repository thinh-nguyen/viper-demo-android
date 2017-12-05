package com.meltwater.viperdemo.documents.router;

import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.UI.BaseActivity;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;

/**
 * Created by thinhnguyen on 12/3/17.
 */

public class DocumentListRouter implements DocumentListContract.Router {

    private BaseActivity view;

    public DocumentListRouter(BaseActivity view) {
        this.view = view;
    }

    @Override
    public void routeToDocumentScreen(DocumentUIModel documentUIModel) {

    }
}
