package com.example.domain.repository;

import com.example.domain.model.Repo;

import java.util.List;

import io.reactivex.Observable;

public interface RepoRepository extends Repository<Repo> {
    Observable<List<Repo>> getAllRepos();

    Observable<List<Repo>> getUserRepos(String login);
}
