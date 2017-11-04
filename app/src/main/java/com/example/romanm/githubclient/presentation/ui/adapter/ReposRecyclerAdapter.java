package com.example.romanm.githubclient.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.romanm.githubclient.R;

/**
 * Created by RomanM on 03.11.2017.
 */

public class ReposRecyclerAdapter extends RecyclerView.Adapter<ReposRecyclerAdapter.ReposViewHolder> {

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repos, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    static class ReposViewHolder extends RecyclerView.ViewHolder {
        TextView idInDatabase;

        TextView idRepos;

        public ReposViewHolder(View itemView) {
            super(itemView);
            idInDatabase = itemView.findViewById(R.id.id_database);
            idRepos = itemView.findViewById(R.id.id_repos);
        }
    }
}
