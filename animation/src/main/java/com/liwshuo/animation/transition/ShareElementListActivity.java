package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.liwshuo.animation.R;

public class ShareElementListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter shareElementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_list);
        setTransition();
        initRecyclerView();
    }

    private void setTransition() {
        Transition imageViewTransiton = TransitionInflater.from(this).inflateTransition(R.transition.image_change);
        getWindow().setSharedElementExitTransition(imageViewTransiton);
        getWindow().setSharedElementReenterTransition(imageViewTransiton);
        getWindow().setExitTransition(new Fade());
        getWindow().setReenterTransition(new Fade());
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        shareElementAdapter = new ShareElementListAdapter(this);
        recyclerView.setAdapter(shareElementAdapter);
    }
}
