package com.meltwater.viperdemo.documents.UI;


import android.os.Bundle;
import android.support.annotation.NonNull;

import com.meltwater.viperdemo.R;
import com.meltwater.viperdemo.documents.presenter.DocumentListPresenter;
import com.meltwater.viperdemo.documents.view.BaseViperView;

public class DocumentListActivity extends BaseActivity<BaseViperView, DocumentListPresenter> implements BaseViperView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_list);
    }

    @Override
    protected void onPresenterPrepared(@NonNull DocumentListPresenter presenter) {

    }

    @Override
    protected int loaderId() {
        return 1;
    }

    @NonNull
    @Override
    public DocumentListPresenter createPresenter() {
        return new DocumentListPresenter();
    }

    @Override
    public void showDocuments(Object data) {

    }
}
