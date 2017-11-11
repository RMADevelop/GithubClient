package com.example.romanm.githubclient.presentation.ui.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.romanm.githubclient.App;
import com.example.romanm.githubclient.R;
import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;
import com.example.romanm.githubclient.presentation.mvp.presenter.ReposPresenterImpl;
import com.example.romanm.githubclient.presentation.mvp.view.ReposListView;
import com.example.romanm.githubclient.presentation.ui.adapter.ReposRecyclerAdapter;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;


public class ReposFragment extends MvpAppCompatFragment implements ReposListView,ReposRecyclerAdapter.ReposRecyclerListener{


//    private static final String ARG_PARAM1 = "param1";

//    private String mParam1;




    @Inject
    @InjectPresenter
    ReposPresenterImpl presenter;

    @ProvidePresenter
    ReposPresenterImpl providePresenter() {
        return presenter;
    }

    private RecyclerView reposReccycler;
    private ReposRecyclerAdapter adapter;
    private Toolbar toolbar;

    public ReposFragment() {
        // Required empty public constructor
    }


    public static ReposFragment newInstance() {
        ReposFragment fragment = new ReposFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repos, container, false);
        initToolbar(view);
        initRecyler(view);
        return view;
    }

    private void initToolbar(View view) {
        toolbar = view.findViewById(R.id.toolbar);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getRepos();

    }

    private void initRecyler(View view) {
        reposReccycler = (RecyclerView) view.findViewById(R.id.recycler_repos);
        adapter = new ReposRecyclerAdapter(Collections.emptyList(),this);
        reposReccycler.setLayoutManager(new LinearLayoutManager(getContext()));
        reposReccycler.setAdapter(adapter);
    }

    @Override
    public void addItemsInAdapter(List<ItemReposDomain> reposList) {
        Log.d(TAG, "addItemsInAdapter() called with: reposList = [" + reposList + "]");
        adapter.setList(reposList);
    }

    @Override
    public void loadMore() {
        presenter.getRepos();
    }


//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
