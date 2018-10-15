package com.example.daniel.githubreposoverview.network;

import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.model.SearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {
    @GET("search/repositories")
    Call<SearchResult> getReposFromApi(@Query("q") String q,
                                       @Query("sort") String sort,
                                       @Query("order") String order,
                                       @Query("per_page") int perPage);
}
