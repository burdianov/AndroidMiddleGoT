package com.testography.androidmiddlegot.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.ui.activities.MainActivity;
import com.testography.androidmiddlegot.ui.adapters.SwornMembersAdapter;

import java.util.ArrayList;

public class HouseOneFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwornMembersAdapter mSwornMembersAdapter;

    public HouseOneFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_house_one, container,
                false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_one);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> names = (ArrayList<String>) getActivity()
                .getIntent().getSerializableExtra("test");

        mSwornMembersAdapter = new SwornMembersAdapter((MainActivity) getActivity(),
                names);
        mRecyclerView.setAdapter(mSwornMembersAdapter);

        return rootView;
    }
}