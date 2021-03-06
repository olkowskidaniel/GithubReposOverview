package com.example.daniel.githubreposoverview.presenter;

import android.util.Log;
import android.view.View;

import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.model.SearchResult;
import com.example.daniel.githubreposoverview.network.GitHubService;
import com.example.daniel.githubreposoverview.view.GitRecyclerViewAdapter;
import com.example.daniel.githubreposoverview.view.IView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryListPresenter {

    private Retrofit retrofit;
    private GitHubService gitHubService;
    private IView view;

    private SearchResult searchResults;

    public void loadList() {
        retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        gitHubService = retrofit.create(GitHubService.class);
        Call<SearchResult> call = gitHubService.getReposFromApi("android", "stars", "desc", 100);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                searchResults = response.body();
                if (view != null) {
                    view.showList(searchResults);
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                view.showError();
                Log.e("error", t.toString());
            }
        });
    }

    public void attach(IView view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

    public void openDetails(SearchResult searchResult, int i) {
        view.openDetailsActivity(searchResult.getItems().get(i));
    }
}