package com.example.daniel.githubreposoverview.view;

import com.example.daniel.githubreposoverview.model.GithubRepo;

import java.util.List;

public interface IView {
    void showList(List<GithubRepo> list);
}
