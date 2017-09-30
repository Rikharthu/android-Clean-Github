package com.example.data.converters;


import com.example.data.models.Owner;
import com.example.data.models.Repo;
import com.example.domain.model.User;

import java.util.Date;

public abstract class DataModelConverter {

    public static com.example.domain.model.Repo convertRepoToDomainModel(Repo repo) {
        com.example.domain.model.Repo domainRepo = new com.example.domain.model.Repo();
        domainRepo.setId(repo.getId());
        domainRepo.setName(repo.getName());
        domainRepo.setFullName(repo.getFullName());
        domainRepo.setOwner(convertUserToDomainModel(repo.getOwner()));
        domainRepo.setPrivate(repo.isPrivate());
        domainRepo.setHtmlUrl(repo.getHtmlUrl());
        domainRepo.setDescription(repo.getDescription());
        domainRepo.setFork(repo.isFork());
//        domainRepo.setCreatedAt(new Date(repo.getCreatedAt()));
//        domainRepo.setUpdatedAt(new Date(repo.getUpdatedAt()));
//        domainRepo.setPushedAt(new Date(repo.getPushedAt()));
        domainRepo.setGitUrl(repo.getGitUrl());
        domainRepo.setSize(repo.getSize());
        domainRepo.setLanguage(repo.getLanguage());
        domainRepo.setForksCount(repo.getForksCount());
        domainRepo.setForks(repo.getForks());
        domainRepo.setWatchersCount(repo.getWatchersCount());
        domainRepo.setDefaultBranch(repo.getDefaultBranch());
        return domainRepo;
    }

    public static User convertUserToDomainModel(Owner owner) {
        User user = new User();
        user.setId(owner.getId());
        user.setAvatarUrl(owner.getAvatarUrl());
        user.setLogin(owner.getLogin());
        user.setAvatarUrl(owner.getAvatarUrl());
        return user;
    }
}
