package com.example.romanm.githubclient.presentation.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.romanm.githubclient.App;
import com.example.romanm.githubclient.R;
import com.example.romanm.githubclient.presentation.mvp.presenter.ReposPresenter;
import com.example.romanm.githubclient.presentation.mvp.view.ReposListView;
import com.example.romanm.githubclient.presentation.ui.adapter.ReposRecyclerAdapter;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReposFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReposFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ReposFragment extends MvpAppCompatFragment implements ReposListView {


//    private static final String ARG_PARAM1 = "param1";

//    private String mParam1;

    private OnFragmentInteractionListener mListener;

//    @Inject
//    ReposPresenter presenter;

//    @ProvidePresenter
//    ReposPresenter providePresenter() {
//        return presenter;
//    }

    private RecyclerView reposReccycler;
    private ReposRecyclerAdapter adapter;

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
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repos, container, false);
        App.getAppComponent().inject(this);

//        presenter.saveItems();
        initRecyler(view);
        return view;
    }

    private void initRecyler(View view) {
        reposReccycler = (RecyclerView) view.findViewById(R.id.recycler_repos);
        adapter = new ReposRecyclerAdapter();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
