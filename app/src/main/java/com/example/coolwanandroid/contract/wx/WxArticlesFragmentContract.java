package com.example.coolwanandroid.contract.wx;

import com.example.coolwanandroid.base.presenter.IPresenter;
import com.example.coolwanandroid.base.view.BaseView;
import com.example.coolwanandroid.model.entity.Article;

import java.util.List;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 公众号文章接口
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public interface WxArticlesFragmentContract {
    interface View extends BaseView {
        void showWxArticles(List<Article> articleList);

        void showMoreWxArticles(List<Article> articleList);

        void initRecyclerView();

        void initRefresh();

        void showCollectSuccess(); //收藏成功

        void showUnCollectSuccess();//取消收藏成功

        void autoRefresh();//强制刷新
    }

    interface Presenter extends IPresenter<View> {
        void loadWxArticlesData(int pageNum, int id);

        void loadMoreWxArticlesData(int pageNum, int id);

        void collectArticles(int id); //收藏首页文章

        void unCollectArticles(int id);//取消收藏
    }
}
