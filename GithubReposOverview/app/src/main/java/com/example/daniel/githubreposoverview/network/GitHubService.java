package com.example.daniel.githubreposoverview.network;

import com.example.daniel.githubreposoverview.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<GithubRepo>> getReposFromApi(@Path("user") String user);
}
