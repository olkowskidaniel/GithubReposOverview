package com.example.daniel.githubreposoverview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.daniel.githubreposoverview.R;
import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.presenter.RepositoryListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {

    //Views
    @BindView(R.id.mainGithubReposTextView)
    TextView mainGithubReposTextView;
    @BindView(R.id.mainReposOverviewRecyclerView)
    RecyclerView mainReposOverviewRecyclerView;

    //Classes
    private GitRecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    public RepositoryListPresenter repositoryListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainReposOverviewRecyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new GitRecyclerViewAdapter();
        mainReposOverviewRecyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewLayoutManager = new LinearLayoutManager(this);

        repositoryListPresenter = new RepositoryListPresenter();
        repositoryListPresenter.loadList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        repositoryListPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        repositoryListPresenter.detach();
    }

    @Override
    public void showList(List<GithubRepo> list) {
        recyclerViewAdapter.setRepos(repositoryListPresenter.getGithubRepos());
    }
}
