package com.example.coolwanandroid.presenter.project;

import com.example.coolwanandroid.base.BaseObserver;
import com.example.coolwanandroid.base.presenter.BasePresenter;
import com.example.coolwanandroid.component.RxBus;
import com.example.coolwanandroid.contract.project.ProjectArticlesFragmentContract;
import com.example.coolwanandroid.event.AutoRefreshEvent;
import com.example.coolwanandroid.event.NoImgEvent;
import com.example.coolwanandroid.model.DataModel;
import com.example.coolwanandroid.model.entity.Articles;
import com.example.coolwanandroid.model.entity.BaseResponse;
import com.example.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;


/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 项目文章
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ProjectArticlesFragmentPresenter extends BasePresenter<ProjectArticlesFragmentContract.View>
        implements ProjectArticlesFragmentContract.Presenter {

    @Inject
    public ProjectArticlesFragmentPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void subscribeEvent() {
        addRxSubscribe(
                RxBus.getInstance().toObservable(AutoRefreshEvent.class)
                        .filter(AutoRefreshEvent::isAutoRefresh)
                        .subscribe(loginEvent -> mView.autoRefresh())
        );

        addRxSubscribe(
                RxBus.getInstance().toObservable(NoImgEvent.class)
                        .subscribe(noImgEvent -> mView.autoRefresh())
        );
    }

    @Override
    public void loadProjectArticlesData(int pageNum, int id) {
        addRxSubscribe(
                mModel.getProjectArticles(pageNum, id)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<Articles>(mView) {
                            @Override
                            public void onNext(Articles articles) {
                                super.onNext(articles);
                                mView.showProjectArticles(articles.getDatas());
                            }
                        })
        );
    }

    @Override
    public void loadMoreProjectArticlesData(int pageNum, int id) {
        addRxSubscribe(
                mModel.getProjectArticles(pageNum, id)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<Articles>(mView, false, false) {
                            @Override
                            public void onNext(Articles articles) {
                                super.onNext(articles);
                                mView.showMoreProjectArticles(articles.getDatas());
                            }
                        })
        );
    }

    @Override
    public void collectArticles(int id) {
        addRxSubscribe(
                mModel.collectArticles(id)
                        .compose(RxUtil.rxSchedulerHelper())
                        .subscribeWith(new BaseObserver<BaseResponse>(mView, false, false) {
                            @Override
                            public void onNext(BaseResponse baseResponse) {
                                mView.showCollectSuccess();
                            }
                        })
        );
    }

    @Override
    public void unCollectArticles(int id) {
        addRxSubscribe(
                mModel.unCollectArticles(id)
                        .compose(RxUtil.rxSchedulerHelper())
                        .subscribeWith(new BaseObserver<BaseResponse>(mView, false, false) {
                            @Override
                            public void onNext(BaseResponse baseResponse) {
                                mView.showUnCollectSuccess();
                            }
                        })
        );
    }
}
