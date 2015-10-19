package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liwshuo.animation.R;

public class ShareElementActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element);
        FragmentManager fragmentManager = getFragmentManager();
        android.app.Fragment listFragment = new ListFragment();
        fragmentManager.beginTransaction().replace(R.id.container, listFragment).commit();

    }
}
