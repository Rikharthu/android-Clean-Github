package com.example.data;

import com.example.domain.model.Repo;
import com.example.domain.model.User;
import com.example.domain.repository.RepoRepository;
import com.example.domain.repository.UserRepository;

import java.util.List;

public class GithubRepository implements UserRepository, RepoRepository {

    @Override
    public boolean insert(Repo model) {
        return false;
    }

    @Override
    public boolean update(Repo model) {
        return false;
    }

    @Override
    public Repo get(long id) {
        return null;
    }

    @Override
    public boolean delete(Repo model) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<Repo> getAllRepos() {
        return null;
    }

    @Override
    public List<Repo> getUserRepos(String login) {
        return null;
    }
}
