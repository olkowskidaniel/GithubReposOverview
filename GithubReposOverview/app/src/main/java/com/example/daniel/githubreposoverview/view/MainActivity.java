package com.example.daniel.githubreposoverview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.TextView;

import com.example.daniel.githubreposoverview.R;
import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.presenter.RepositoryListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView, OnItemClickListener {

    //Views
    @BindView(R.id.mainGithubReposTextView)
    TextView mainGithubReposTextView;
    @BindView(R.id.mainReposOverviewRecyclerView)
    RecyclerView mainReposOverviewRecyclerView;

    //Classes
    private GitRecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private RepositoryListPresenter repositoryListPresenter;
    private Intent detailsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainReposOverviewRecyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new GitRecyclerViewAdapter(this);
        mainReposOverviewRecyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mainReposOverviewRecyclerView.getContext(), 1);
        mainReposOverviewRecyclerView.addItemDecoration(dividerItemDecoration);

        repositoryListPresenter = new RepositoryListPresenter();
        repositoryListPresenter.loadList();

        detailsIntent = new Intent(this, RepoDetailsActivity.class);
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
        recyclerViewAdapter.setRepos(list);
        recyclerViewAdapter.notifyDataSetChanged();
    }

    public void openDetailsActivity() {
        startActivity(detailsIntent);
    }

    @Override
    public void onItemClick(GithubRepo repo) {
        repositoryListPresenter.openDetails();
    }
}
