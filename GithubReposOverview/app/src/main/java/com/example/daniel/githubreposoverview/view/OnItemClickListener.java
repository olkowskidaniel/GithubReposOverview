package com.example.daniel.githubreposoverview.view;

import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.model.SearchResult;

public interface OnItemClickListener {
    void onItemClick(SearchResult searchResult, int i);
}
