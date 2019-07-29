package com.example.coolwanandroid.di.module.activity;

import android.support.v4.app.Fragment;

import com.example.coolwanandroid.base.fragment.BaseFragment;
import com.example.coolwanandroid.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Module
public class MainActivityModule {

    @Provides
    @PerActivity
    Fragment[] provideFragments() {
        return new BaseFragment[5];
    }
}
