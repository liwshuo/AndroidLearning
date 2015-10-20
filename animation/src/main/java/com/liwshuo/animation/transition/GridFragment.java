package com.liwshuo.animation.transition;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liwshuo.animation.R;


public class GridFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter shareElementAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        shareElementAdapter = new ShareElementGridFragmentAdapter(getActivity());
        recyclerView.setAdapter(shareElementAdapter);
        return view;
    }
}
