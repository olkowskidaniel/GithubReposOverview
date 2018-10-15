package com.example.daniel.githubreposoverview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.daniel.githubreposoverview.R;
import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.model.GithubRepoOwner;
import com.example.daniel.githubreposoverview.model.SearchResult;
import com.example.daniel.githubreposoverview.presenter.RepositoryDetailsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoDetailsActivity extends AppCompatActivity implements IViewDetails {

    @BindView(R.id.nameRepoDetailsTextView)
    TextView nameRepoDetailsTextView;
    @BindView(R.id.ownerRepoDetailsTextView)
    TextView ownerRepoDetailsTextView;
    @BindView(R.id.ownerLoginRepoDetailsTextView)
    TextView ownerLoginRepoDetailsTextView;

    RepositoryDetailsPresenter repositoryDetailsPresenter;
    GithubRepo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        ButterKnife.bind(this);
        repositoryDetailsPresenter = new RepositoryDetailsPresenter();
        repositoryDetailsPresenter.attach(this);
        repo = getIntent().getParcelableExtra("githubRepo");
        repositoryDetailsPresenter.parseParcel(repo);
    }

    @Override
    protected void onStop() {
        super.onStop();
        repositoryDetailsPresenter.detach();
    }

    public void showRepo(String name, String owner) {
        nameRepoDetailsTextView.setText(name);
        ownerLoginRepoDetailsTextView.setText(owner);
    }
}
