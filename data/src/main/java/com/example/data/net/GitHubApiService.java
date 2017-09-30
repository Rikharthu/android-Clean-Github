package com.example.data.net;


import com.example.data.models.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApiService {
    @GET("users/{user}/repos")
    Call<List<Repo>> getUserRepos(@Path("user") String user);
}
