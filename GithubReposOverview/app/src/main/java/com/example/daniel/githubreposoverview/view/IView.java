package com.example.daniel.githubreposoverview.view;

import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.model.SearchResult;

import java.util.List;

public interface IView {
    void showList(SearchResult list);
    void openDetailsActivity(GithubRepo repo);
    void showError();
}
