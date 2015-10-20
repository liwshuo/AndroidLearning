package com.liwshuo.animation.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.liwshuo.animation.R;

public class ShareElementActivityA extends AppCompatActivity implements View.OnClickListener{

    ImageView imageViewA;
    ImageView imageViewB;
    /**
     * 默认
     */
    public static final int TRANSITIONA = 0;
    public static final int TRANSITIONB = 1;
    public static final int TRANSITIONC = 2;
    public static final int TRANSITIOND = 3;
    public static final int TRANSITIONE = 4;
    public static final int TRANSITIONF = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_activity_a);
        imageViewA = (ImageView) findViewById(R.id.imageViewA);
        imageViewB = (ImageView) findViewById(R.id.imageViewB);
        imageViewA.setOnClickListener(this);
        imageViewB.setOnClickListener(this);

    //    Transition imageViewTransiton = TransitionInflater.from(this).inflateTransition(R.transition.image_change);
    //    getWindow().setSharedElementExitTransition(imageViewTransiton);
    //    getWindow().setSharedElementReenterTransition(imageViewTransiton);
        getWindow().setExitTransition(new Fade());
        getWindow().setReenterTransition(new Fade());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        switch (view.getId()) {

            case R.id.imageViewA:
                intent.putExtra("transitionName", imageViewA.getTransitionName());
                intent.putExtra("drawable", R.drawable.imagea);
                bundle = ActivityOptions.makeSceneTransitionAnimation(ShareElementActivityA.this, new Pair<View, String>(imageViewA, imageViewA.getTransitionName())).toBundle();
                break;
            case R.id.imageViewB:
                intent.putExtra("transitionName", imageViewB.getTransitionName());
                intent.putExtra("drawable", R.drawable.imageb);
                bundle = ActivityOptions.makeSceneTransitionAnimation(ShareElementActivityA.this, new Pair<View, String>(imageViewB, imageViewB.getTransitionName())).toBundle();
                break;
        }
        intent.setClass(ShareElementActivityA.this, ShareElementActivityB.class);
        startActivity(intent,bundle);
    }
}
