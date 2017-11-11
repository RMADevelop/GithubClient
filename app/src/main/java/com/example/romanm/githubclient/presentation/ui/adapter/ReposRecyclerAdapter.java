package com.example.romanm.githubclient.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.romanm.githubclient.R;
import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 03.11.2017.
 */

public class ReposRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_ITEM = 0;
    private final static int TYPE_FOOTER = 1;

    List<ItemReposDomain> reposList = new ArrayList<>();

    public ReposRecyclerAdapter(List<ItemReposDomain> reposList) {
        Log.d(TAG, "ReposRecyclerAdapter() called with: reposList = [" + reposList + "]");
        this.reposList.addAll(reposList);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount()-1) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_ITEM) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repos, parent, false);
            return new ReposViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false);
            return new FooterViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReposViewHolder) {
            ReposViewHolder holderItem = (ReposViewHolder) holder;
            holderItem.bindTo(reposList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        int itemCount = reposList.size();

        //footer
        itemCount++;

        return itemCount;
    }

    public void setList(List<ItemReposDomain> list) {
        reposList.addAll(list);
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

        void bindTo(ItemReposDomain reposItem) {
            idInDatabase.setText(String.valueOf(getAdapterPosition()));
            idRepos.setText(String.valueOf(reposItem.getIdRepos()));
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
