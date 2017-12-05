package com.meltwater.viperdemo.documents.view;

import android.support.annotation.UiThread;

/**
 * Created by marcogalicia on 12/5/17.
 */

public interface BaseViperView<M> extends ViperView {

    @UiThread
    void showDocuments(M data);

}
