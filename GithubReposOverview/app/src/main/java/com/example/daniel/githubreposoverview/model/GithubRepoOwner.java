package com.example.daniel.githubreposoverview.model;

public class GithubRepoOwner {
    private String login;
    private int id;
    private String html_url;
    private GithubRepoOwner owner;

    public GithubRepoOwner(String login, int id, String html_url) {
        this.login = login;
        this.id = id;
        this.html_url = html_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
