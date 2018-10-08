package com.example.daniel.githubreposoverview.model;

public class GithubRepo {
    private String name;
    private String watchers_count;

    public GithubRepo(String name, String watchers_count) {
        this.name = name;
        this.watchers_count = watchers_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWatchersCount() {
        return watchers_count;
    }

    public void setStarsAmount(String starsAmount) {
        this.watchers_count = watchers_count;
    }
}
