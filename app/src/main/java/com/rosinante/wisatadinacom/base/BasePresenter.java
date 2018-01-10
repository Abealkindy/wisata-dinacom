package com.rosinante.wisatadinacom.base;

import com.rosinante.wisatadinacom.network.ApiClient;
import com.rosinante.wisatadinacom.network.ServiceApi;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Rosinante24 on 10/01/18.
 */

public class BasePresenter<V> {
    public V mvpView;
    protected ServiceApi serviceApi;
    private CompositeSubscription mCompositeSubsc;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        serviceApi = ApiClient.request().create(ServiceApi.class);
    }


    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }

    public void onUnsubscribe() {
        if (mCompositeSubsc != null && mCompositeSubsc.hasSubscriptions()) {
            mCompositeSubsc.unsubscribe();
        }
    }


    public void addSubscription(Observable<?> observable, Subscriber<Object> subscriber) {
        if (mCompositeSubsc == null) {
            mCompositeSubsc = new CompositeSubscription();
        }
        mCompositeSubsc.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
