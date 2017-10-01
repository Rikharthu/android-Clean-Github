package com.example.domain.interactors.impl;

import com.example.domain.executors.Executor;
import com.example.domain.executors.PostExecutionThread;
import com.example.domain.interactors.base.UseCase;
import com.example.domain.model.Repo;
import com.example.domain.repository.RepoRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserRepos extends UseCase<List<Repo>, String> {

    private final RepoRepository mRepoRepository;

    @Inject
    public GetUserRepos(Executor threadExecutor, PostExecutionThread postExecutionThread, RepoRepository repoRepository) {
        super(threadExecutor, postExecutionThread);
        mRepoRepository = repoRepository;
    }


    @Override
    public Observable<List<Repo>> buildUseCaseObservable(String login) {
        return mRepoRepository.getUserRepos(login);
    }
}
