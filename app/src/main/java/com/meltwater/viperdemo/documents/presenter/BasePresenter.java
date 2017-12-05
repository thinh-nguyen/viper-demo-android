package com.meltwater.viperdemo.documents.presenter;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import com.meltwater.viperdemo.documents.view.ViperView;

import java.lang.ref.WeakReference;

/**
 * Created by marcogalicia on 25/10/16.
 */

public class BasePresenter <V extends ViperView> implements ViperPresenter<V> {

    private WeakReference<V> viewRef;

    @UiThread
    @Override public void attachView(V view) {
        viewRef = new WeakReference<>(view);
    }

    @UiThread
    @Nullable
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    @UiThread
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @UiThread
    @Override public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public void onFinish() {

    }

}
