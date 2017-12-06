package com.meltwater.viperdemo.documents.UI;

import android.content.Context;
import android.content.Loader;
import android.util.Log;

import com.meltwater.viperdemo.documents.presenter.ViperPresenter;
import com.meltwater.viperdemo.documents.view.ViperView;

/**
 * Created by marcogalicia on 19/03/17.
 */

public final class PresenterLoader<V extends ViperView,P extends ViperPresenter<V>> extends Loader<P> {

    private P presenter;
    private int count=0;

    public PresenterLoader(Context context,P presenter) {
        super(context);
        this.presenter=presenter;
    }

    @Override
    protected void onStartLoading() {
        Log.i("loader", "onStartLoading-count: "+count++);

        // if we already own a presenter instance, simply deliver it.
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }

        // Otherwise, force a load
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        Log.i("loader", "onForceLoad-");
        // Deliver the result
        deliverResult(presenter);
    }

    @Override
    public void deliverResult(P data) {
        super.deliverResult(data);
        Log.i("loader", "deliverResult-");
    }

    @Override
    protected void onStopLoading() {
        Log.i("loader", "onStopLoading-");
    }

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onReset() {
        Log.i("loader", "onReset-" );
        if (presenter != null) {
            presenter.onFinish();
            presenter = null;
        }
    }
}