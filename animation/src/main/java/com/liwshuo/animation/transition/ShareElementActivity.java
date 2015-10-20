package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.TransitionInflater;

import com.liwshuo.animation.R;

public class ShareElementActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element);
        FragmentManager fragmentManager = getFragmentManager();
        android.app.Fragment listFragment = new ListFragment();
        listFragment.setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.image_change));
       // listFragment.setExitTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.fade));
        fragmentManager.beginTransaction().addToBackStack("shareElement").replace(R.id.container, listFragment,"listFragment").commit();
        getWindow().setExitTransition(new Fade());
        getWindow().setReenterTransition(new Fade());
    }
}
