package com.rosinante.wisatadinacom.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 10/01/18.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getFragmentLayout(), container, false);
        ButterKnife.bind(this, rootView);
        doCreateFragment();
        return rootView;
    }

    public abstract
    @LayoutRes
    int getFragmentLayout();

    public abstract void doCreateFragment();
}
