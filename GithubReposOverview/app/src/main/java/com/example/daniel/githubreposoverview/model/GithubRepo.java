package com.example.daniel.githubreposoverview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GithubRepo implements Parcelable {
    private String name;
    private String watchers_count;

    public GithubRepoOwner getOwner() {
        return owner;
    }

    private GithubRepoOwner owner;

    public GithubRepo(){}

    public GithubRepo(Parcel in) {
        name = in.readString();
        watchers_count = in.readString();
        owner = in.readParcelable(GithubRepoOwner.class.getClassLoader());
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

    public String getOwnerLogin() {
        return owner.getLogin();
    }

   public void setOwnerLogin(String login) {
        owner.setLogin(login);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(watchers_count);
        parcel.writeParcelable(owner, i);
    }

    public static final Parcelable.Creator<GithubRepo> CREATOR = new Parcelable.Creator<GithubRepo>(){
        @Override
        public GithubRepo createFromParcel(Parcel parcel) {
            return new GithubRepo(parcel);
        }

        @Override
        public GithubRepo[] newArray(int i) {
            return new GithubRepo[i];
        }
    };
}

