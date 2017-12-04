package com.meltwater.viperdemo.documents.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.meltwater.viperdemo.R;
import com.meltwater.viperdemo.documents.DocumentListContract;
import com.meltwater.viperdemo.documents.entity.DocumentUIModel;
import com.meltwater.viperdemo.documents.presenter.DocumentListPresenter;

import java.util.List;

public class DocumentListActivity extends AppCompatActivity implements DocumentListContract.View, DocumentListFragment.OnListFragmentInteractionListener {

    private DocumentListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_list);

        // On iOS the Router create the Presenter, cannot do it here at least for the 1st Activity
        presenter = new DocumentListPresenter(this);

        presenter.presentDocuments();

    }

    @Override // DocumentListContract.View
    public void showDocuments(List<DocumentUIModel> documentsUIModels) {
        DocumentListFragment documentListFragment = DocumentListFragment.newInstance(1, documentsUIModels);// 1column
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.add(R.id.mainContent, documentListFragment, "contentStream");
        transaction.replace(R.id.mainContent, documentListFragment, "contentStream");
        transaction.commit();
    }

    @Override
    public void onListFragmentInteraction(DocumentUIModel item){

    }
}
