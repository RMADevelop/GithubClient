package com.example.romanm.githubclient.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.romanm.githubclient.R;
import com.example.romanm.githubclient.domain.models.Repos;
import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 03.11.2017.
 */

public class ReposRecyclerAdapter extends RecyclerView.Adapter<ReposRecyclerAdapter.ReposViewHolder> {

     List<ReposLocal> reposList = new ArrayList<>();

    public ReposRecyclerAdapter(List<ReposLocal> reposList) {
        Log.d(TAG, "ReposRecyclerAdapter() called with: reposList = [" + reposList + "]");
        this.reposList.addAll(reposList);
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repos, parent, false);
        Log.d(TAG, "onCreateViewHolder() called with: parent = [" + parent + "], viewType = [" + viewType + "]");
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder() called with: holder = [" + holder + "], position = [" + position + "]");
        holder.bindTo(reposList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount() called " + reposList.size());
        return reposList.size();
    }

    public void setList(List<ReposLocal> list) {
        Log.d(TAG, "setList() called with: reposList = [" + list.size() + "]");
        reposList.addAll(list);
        Log.d(TAG, "setList() returned: ok");
        notifyDataSetChanged();

//        notifyItemInserted(this.reposList.size());
    }


    static class ReposViewHolder extends RecyclerView.ViewHolder {
        TextView idInDatabase;

        TextView idRepos;

        public ReposViewHolder(View itemView) {
            super(itemView);
            idInDatabase = itemView.findViewById(R.id.id_database);
            idRepos = itemView.findViewById(R.id.id_repos);
        }

        void bindTo(ReposLocal reposItem) {
            idInDatabase.setText(String.valueOf(getAdapterPosition()));
            idRepos.setText(String.valueOf(reposItem.getIdRepos()));
        }
    }
}
