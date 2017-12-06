package com.meltwater.viperdemo.documents.UI;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.meltwater.viperdemo.documents.presenter.ViperPresenter;
import com.meltwater.viperdemo.documents.view.ViperView;

import static android.content.ContentValues.TAG;

public abstract class BaseActivity<V extends ViperView, P extends ViperPresenter<V>>
        extends Activity implements ViperDelegateCallback<V, P>, ViperView {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(loaderId(), null, new LoaderManager.LoaderCallbacks<P>() {
            @Override
            public final Loader<P> onCreateLoader(int id, Bundle args) {
                Log.i(TAG, "onCreateLoader");
                return new PresenterLoader<>(BaseActivity.this, createPresenter());
            }

            @Override
            public final void onLoadFinished(Loader<P> loader, P presenter) {
                Log.i(TAG, "onLoadFinished");
                BaseActivity.this.presenter = presenter;
                onPresenterPrepared(presenter);
            }

            @Override
            public final void onLoaderReset(Loader<P> loader) {
                Log.i(TAG, "onLoaderReset");
                BaseActivity.this.presenter = null;
                onPresenterDestroyed();
            }
        });
    }

    protected abstract void onPresenterPrepared(@NonNull P presenter);

    protected void onPresenterDestroyed() {
    }

    //This method I do not like because we should implement this method in any activity/fragment but Loader needs a unique ID :(
    protected abstract int loaderId();

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

