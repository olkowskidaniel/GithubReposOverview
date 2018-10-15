package com.example.daniel.githubreposoverview.presenter;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.model.GithubRepoOwner;
import com.example.daniel.githubreposoverview.model.SearchResult;
import com.example.daniel.githubreposoverview.view.IViewDetails;

public class RepositoryDetailsPresenter {
    private IViewDetails viewDetails;

    public void attach(IViewDetails viewDetails){
        this.viewDetails = viewDetails;
    }
    public void detach(){
        this.viewDetails = null;
    }
    public void parseParcel(GithubRepo repo){
        viewDetails.showRepo(repo.getName(), repo.getOwner().getLogin());
    }
}
