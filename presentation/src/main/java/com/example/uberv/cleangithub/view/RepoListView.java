package com.example.uberv.cleangithub.view;

import com.example.uberv.cleangithub.model.RepoModel;

import java.util.List;

public interface RepoListView extends LoadDataView {

    /**
     * Render a repo list in the UI
     *
     * @param repoModels
     */
    void renderRepoList(List<RepoModel> repoModels);

    /**
     * View a {@link RepoModel} description/details
     *
     * @param repoModel
     */
    void viewRepo(RepoModel repoModel);
}
