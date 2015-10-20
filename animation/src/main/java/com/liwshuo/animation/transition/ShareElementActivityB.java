package com.liwshuo.animation.transition;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;
import android.widget.ImageView;

import com.liwshuo.animation.R;

public class ShareElementActivityB extends AppCompatActivity {

    ImageView shareImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_activity_b);
        Transition imageViewTransiton = TransitionInflater.from(this).inflateTransition(R.transition.image_change);
        getWindow().setSharedElementEnterTransition(imageViewTransiton);
        getWindow().setSharedElementReturnTransition(imageViewTransiton);
        getWindow().setEnterTransition(new Fade());
        getWindow().setReturnTransition(new Fade());
        shareImage = (ImageView) findViewById(R.id.shareImage);
        String transitionName = getIntent().getStringExtra("transitionName");
        System.out.println("transitionName:" + transitionName);
        shareImage.setTransitionName(transitionName);
        int drawable = getIntent().getIntExtra("drawable", R.drawable.imagea);
        shareImage.setImageDrawable(getDrawable(drawable));

    }
}
