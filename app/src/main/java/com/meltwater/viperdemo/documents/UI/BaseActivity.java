package com.meltwater.viperdemo.documents.UI;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.meltwater.viperdemo.R;
import com.meltwater.viperdemo.documents.presenter.ViperPresenter;
import com.meltwater.viperdemo.documents.view.ViperView;

public abstract class BaseActivity<V extends ViperView, P extends ViperPresenter<V>>
        extends Activity implements ViperDelegateCallback<V, P>, ViperView {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @NonNull
    @Override
    public abstract P createPresenter();

    @Override
    public P getPresenter() {
        return presenter;
    }

    @NonNull
    @Override
    public V getViperView() {
        return (V) this;
    }

    @Override
    public void finish() {
        if (getPresenter() != null)
            getPresenter().onFinish();
        super.finish();
    }

}

