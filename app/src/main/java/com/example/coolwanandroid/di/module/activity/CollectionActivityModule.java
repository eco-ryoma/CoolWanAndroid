package com.example.coolwanandroid.di.module.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.example.coolwanandroid.R;
import com.example.coolwanandroid.app.App;
import com.example.coolwanandroid.adapter.CollectionAdapter;
import com.example.coolwanandroid.di.scope.PerActivity;
import com.example.coolwanandroid.model.entity.Collection;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 收藏
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
@Module
public class CollectionActivityModule {
    @PerActivity
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(App.getContext());
    }

    @PerActivity
    @Provides
    List<Collection> provideCollectionList() {
        return new ArrayList<>();
    }

    @PerActivity
    @Provides
    CollectionAdapter provideCollectionAdapter(List<Collection> collections) {
        return new CollectionAdapter(R.layout.item_home_list, collections);
    }
}
