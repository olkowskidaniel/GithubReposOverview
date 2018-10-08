package com.example.daniel.githubreposoverview.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.githubreposoverview.R;
import com.example.daniel.githubreposoverview.model.GithubRepo;

import java.util.ArrayList;
import java.util.List;


public class GitRecyclerViewAdapter extends RecyclerView.Adapter<GitRecyclerViewAdapter.ViewHolder> {
    //private LayoutInflater layoutInflater;
    private List<GithubRepo> repos = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repos_overview_listrow, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GithubRepo githubRepo = repos.get(i);
        Log.d("name from adapter", repos.get(0).getName());

        viewHolder.listrowRepoNameTextView.setText(githubRepo.getName());
        viewHolder.listrowStarAmountTextView.setText(getItemCount());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView listrowRepoNameTextView;
        public TextView listrowStarAmountTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            listrowRepoNameTextView = (TextView) itemView.findViewById(R.id.listrowRepoNameTextView);
            listrowStarAmountTextView = (TextView) itemView.findViewById(R.id.listrowStarAmountTextView);
        }
    }

    public void setRepos(List<GithubRepo> repos) {
        this.repos = repos;
    }
}
