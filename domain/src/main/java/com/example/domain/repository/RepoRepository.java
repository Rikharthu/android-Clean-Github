package com.example.domain.repository;

import com.example.domain.model.Repo;

import java.util.List;

public interface RepoRepository extends Repository<Repo> {
    List<Repo> getAllRepos();

    List<Repo> getUserRepos(String login);
}
