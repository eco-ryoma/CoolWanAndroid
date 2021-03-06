package com.ryoma.coolwanandroid.di.module.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.ryoma.coolwanandroid.R;
import com.ryoma.coolwanandroid.app.App;
import com.ryoma.coolwanandroid.adapter.ArticlesAdapter;
import com.ryoma.coolwanandroid.di.scope.PerActivity;
import com.ryoma.coolwanandroid.model.entity.Article;

import java.util.ArrayList;
import java.util.List;

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
public class SearchArticlesActivityModule {
    @PerActivity
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(App.getContext());
    }

    @PerActivity
    @Provides
    List<Article> provideCollectionList() {
        return new ArrayList<>();
    }

    @PerActivity
    @Provides
    ArticlesAdapter provideArticlesAdapter(List<Article> articles) {
        return new ArticlesAdapter(R.layout.item_home_list, articles);
    }
}
