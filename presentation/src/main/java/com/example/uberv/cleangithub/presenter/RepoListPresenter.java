package com.example.uberv.cleangithub.presenter;

import android.support.annotation.NonNull;

import com.example.domain.interactors.impl.GetUserRepos;
import com.example.uberv.cleangithub.converters.RepoModelConverter;
import com.example.uberv.cleangithub.view.RepoListView;

import javax.inject.Inject;

public class RepoListPresenter implements Presenter {

    private RepoListView mRepoListView;

    private final GetUserRepos mGetReposListUseCase;
    private final RepoModelConverter mRepoModelConverter;

    @Inject
    public RepoListPresenter(GetUserRepos getReposListUseCase, RepoModelConverter repoModelConverter) {
        mGetReposListUseCase = getReposListUseCase;
        mRepoModelConverter = repoModelConverter;
    }

    public void setView(@NonNull RepoListView view) {
        mRepoListView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mRepoListView = null;
    }

    public void initialize() {
        loadRepoList();
    }

    /**
     * Loads all repos
     */
    private void loadRepoList() {
        hideViewRetry();
        showViewLoading();
        getRepoList();
    }

    private void showViewRetry() {
        mRepoListView.showRetry();
    }

    private void hideViewRetry() {
        mRepoListView.hideRetry();
    }

    private void showViewLoading() {
        mRepoListView.showLoading();
    }

    private void hideViewLoading() {
        mRepoListView.hideLoading();
    }

    private void getRepoList() {
        mGetReposListUseCase.run();
    }
}
