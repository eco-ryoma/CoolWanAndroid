package com.ryoma.coolwanandroid.presenter.home;

import com.ryoma.coolwanandroid.base.BaseObserver;
import com.ryoma.coolwanandroid.base.presenter.BasePresenter;
import com.ryoma.coolwanandroid.contract.home.ArticleActivityContract;
import com.ryoma.coolwanandroid.model.DataModel;
import com.ryoma.coolwanandroid.model.entity.BaseResponse;
import com.ryoma.coolwanandroid.utils.RxUtil;

import javax.inject.Inject;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description ArticleActivityPresenter
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class ArticleActivityPresenter extends BasePresenter<ArticleActivityContract.View> implements ArticleActivityContract.Presenter {

    @Inject
    public ArticleActivityPresenter(DataModel model) {
        super(model);
    }

    @Override
    public void collectArticles(int id) {
        addRxSubscribe(mModel.collectArticles(id)
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
        addRxSubscribe(mModel.unCollectArticles(id)
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
