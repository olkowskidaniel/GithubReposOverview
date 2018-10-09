package com.example.daniel.githubreposoverview.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
    private OnItemClickListener listener;

    public GitRecyclerViewAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repos_overview_listrow, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(repos.get(i), listener);
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

        public void bind(final GithubRepo repo, final OnItemClickListener listener) {
            listrowRepoNameTextView.setText(repo.getName());
            listrowStarAmountTextView.setText(repo.getWatchersCount());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(repo);
                }
            });
        }
    }

    public void setRepos(List<GithubRepo> repos) {
        this.repos = repos;
    }
}
