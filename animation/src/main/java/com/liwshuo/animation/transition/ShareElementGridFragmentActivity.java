package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;

import com.liwshuo.animation.R;
import com.liwshuo.animation.util.ConstantValue;

public class ShareElementGridFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_grid_fragment);
        FragmentManager fragmentManager = getFragmentManager();
        android.app.Fragment gridFragment = new GridFragment();
      //  gridFragment.setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.image_change));
     //   gridFragment.setExitTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.fade));
        fragmentManager.beginTransaction().addToBackStack(ConstantValue.SHARE_ELEMENT_FRAGMENT_BACK_STACK)
                .replace(R.id.container, gridFragment, ConstantValue.GRID_FRAGMENT_NAME).commit();
    }
}
