package com.meltwater.viperdemo.documents.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.meltwater.viperdemo.R;
import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;

import java.util.List;

public class DocumentListActivity extends AppCompatActivity implements DocumentListContract.View {

    DocumentListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_list);
    }

    @Override // DocumentListContract.View
    public void showDocuments(List<DocumentUIModel> UIDocuments) {

    }
}
