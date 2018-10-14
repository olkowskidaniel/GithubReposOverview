package com.example.daniel.githubreposoverview.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.githubreposoverview.R;
import com.example.daniel.githubreposoverview.model.GithubRepo;
import com.example.daniel.githubreposoverview.model.SearchResult;

import java.util.ArrayList;
import java.util.List;


public class GitRecyclerViewAdapter extends RecyclerView.Adapter<GitRecyclerViewAdapter.ViewHolder> {
    private SearchResult searchResult = new SearchResult();
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
        viewHolder.bind(searchResult, listener, i);
    }

    @Override
    public int getItemCount() {
        if(searchResult.getItems() != null)
            return searchResult.getItems().size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView listrowRepoNameTextView;
        public TextView listrowStarAmountTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            listrowRepoNameTextView = (TextView) itemView.findViewById(R.id.listrowRepoNameTextView);
            listrowStarAmountTextView = (TextView) itemView.findViewById(R.id.listrowStarAmountTextView);
        }

        public void bind(final SearchResult searchResult, final OnItemClickListener listener, final int i) {
            listrowRepoNameTextView.setText(searchResult.getItems().get(i).getName());
            listrowStarAmountTextView.setText(searchResult.getItems().get(i).getWatchersCount());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(searchResult, i);
                }
            });
        }
    }

    public void setRepos(SearchResult searchResult) {
        this.searchResult = searchResult;
    }
}
