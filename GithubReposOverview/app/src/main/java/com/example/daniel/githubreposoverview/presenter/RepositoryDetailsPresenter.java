package com.example.daniel.githubreposoverview.presenter;

import com.example.daniel.githubreposoverview.view.IView;

public class RepositoryDetailsPresenter {
    private IView view;

    public void attach(IView view){
        this.view = view;
    }
    public void detach(){
        this.view = null;
    }
    public void openDetails(){
        view.openDetailsActivity();
    }

}
