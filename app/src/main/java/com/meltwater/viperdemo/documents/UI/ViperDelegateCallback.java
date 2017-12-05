package com.meltwater.viperdemo.documents.UI;

import android.support.annotation.NonNull;

import com.meltwater.viperdemo.documents.presenter.ViperPresenter;
import com.meltwater.viperdemo.documents.view.ViperView;

/**
 * Created by marcogalicia on 12/5/17.
 */

public interface ViperDelegateCallback<V extends ViperView, P extends ViperPresenter<V>> {
    @NonNull
    public P createPresenter();
    public P getPresenter();
    public V getViperView();
}
