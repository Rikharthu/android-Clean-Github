package com.example.uberv.cleangithub.converters;

import com.example.uberv.cleangithub.model.RepoModel;

import java.util.ArrayList;
import java.util.List;

public abstract class RepoModelConverter {

    public static List<RepoModel> convertReposToRepoViewModels(List<com.example.domain.model.Repo> domainRepos) {
        List<RepoModel> result = new ArrayList<>();

        if (domainRepos == null || domainRepos.size() == 0) {
            return result;
        }

        for (com.example.domain.model.Repo domainRepo : domainRepos) {
            result.add(convertDomainRepoToRepoViewModel(domainRepo));
        }

        return result;
    }

    private static RepoModel convertDomainRepoToRepoViewModel(com.example.domain.model.Repo domainRepo) {
        if (domainRepo == null) {
            return null;
        }
        RepoModel result = new RepoModel();
        result.setId(domainRepo.getId());
        result.setName(domainRepo.getName());
        result.setPrivate(domainRepo.isPrivate());
        result.setFork(domainRepo.isFork());
        result.setCreatedAt(domainRepo.getCreatedAt());
        result.setUpdatedAt(domainRepo.getUpdatedAt());
        result.setGitUrl(domainRepo.getGitUrl());
        result.setSize(domainRepo.getSize());
        result.setLanguage(domainRepo.getLanguage());
        result.setForksCount(domainRepo.getForksCount());
        result.setForks(domainRepo.getForks());
        result.setWatchersCount(domainRepo.getWatchersCount());
        result.setDefaultBranch(domainRepo.getDefaultBranch());
        result.setOwnerId(domainRepo.getOwner().getId());
        result.setOwnerUsername(domainRepo.getOwner().getLogin());
        result.setOwnerAvatarUrl(domainRepo.getOwner().getAvatarUrl());
        return result;
    }
}
