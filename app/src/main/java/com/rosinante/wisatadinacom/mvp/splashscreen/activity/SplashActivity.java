package com.rosinante.wisatadinacom.mvp.splashscreen.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rosinante.wisatadinacom.R;
import com.rosinante.wisatadinacom.mvp.splashscreen.presenter.SplashPresenter;
import com.rosinante.wisatadinacom.mvp.splashscreen.view.SplashView;
import com.rosinante.wisatadinacom.ui.MvpActivity;

public class SplashActivity extends MvpActivity<SplashPresenter> implements SplashView {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected SplashPresenter createPresenter() {
        return null;
    }
}