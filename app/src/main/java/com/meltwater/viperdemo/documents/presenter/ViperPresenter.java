package com.meltwater.viperdemo.documents.presenter;

import android.support.annotation.UiThread;

import com.meltwater.viperdemo.documents.view.ViperView;

/**
 * Created by marcogalicia on 12/5/17.
 */

public interface ViperPresenter<V extends ViperView> {

    @UiThread
    void attachView(V view);

    @UiThread
    void detachView();

    void onFinish();

}