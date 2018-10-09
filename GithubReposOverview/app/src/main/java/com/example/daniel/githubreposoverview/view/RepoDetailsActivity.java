package com.example.daniel.githubreposoverview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.daniel.githubreposoverview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoDetailsActivity extends AppCompatActivity implements IViewDetails {

    @BindView(R.id.nameRepoDetailsTextView)
    TextView nameRepoDetailsTextView;
    @BindView(R.id.ownerRepoDetailsTextView)
    TextView ownerRepoDetailsTextView;
    @BindView(R.id.ownerLoginRepoDetailsTextView)
    TextView ownerLoginRepoDetailsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        ButterKnife.bind(this);
    }
}
