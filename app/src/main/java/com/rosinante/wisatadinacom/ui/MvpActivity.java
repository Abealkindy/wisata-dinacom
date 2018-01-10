package com.rosinante.wisatadinacom.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rosinante.wisatadinacom.base.BaseActivity;
import com.rosinante.wisatadinacom.base.BasePresenter;

/**
 * Created by Rosinante24 on 10/01/18.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {

    protected P mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);

    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    public void showLoading() {
        showProgressDialog();
    }

    public void hideLoading() {
        dismissProgressDialog();
    }
}
