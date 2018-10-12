package com.example.daniel.githubreposoverview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GithubRepoOwner implements Parcelable{
    private String login;
    private int id;
    private String html_url;
    private GithubRepoOwner owner;


    protected GithubRepoOwner(Parcel in) {
        login = in.readString();
        id = in.readInt();
        html_url = in.readString();
        owner = in.readParcelable(GithubRepoOwner.class.getClassLoader());
    }

    public static final Creator<GithubRepoOwner> CREATOR = new Creator<GithubRepoOwner>() {
        @Override
        public GithubRepoOwner createFromParcel(Parcel in) {
            return new GithubRepoOwner(in);
        }

        @Override
        public GithubRepoOwner[] newArray(int size) {
            return new GithubRepoOwner[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeInt(id);
        parcel.writeString(html_url);
        parcel.writeParcelable(owner, i);
    }
}
