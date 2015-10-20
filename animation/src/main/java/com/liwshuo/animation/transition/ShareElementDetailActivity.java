package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.liwshuo.animation.R;

import java.util.ArrayList;
import java.util.List;

public class ShareElementDetailActivity extends AppCompatActivity {

    ImageView shareImage;
    static List<Integer> data = new ArrayList<>();

    static {
            data.add(R.drawable.imagea);
            data.add(R.drawable.imageb);
            data.add(R.drawable.imagec);
            data.add(R.drawable.imaged);
            data.add(R.drawable.imagee);
            data.add(R.drawable.imagef);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_detail);
        Transition imageViewTransiton = TransitionInflater.from(this).inflateTransition(R.transition.image_change);
        getWindow().setSharedElementEnterTransition(imageViewTransiton);
        getWindow().setSharedElementReturnTransition(imageViewTransiton);
        getWindow().setEnterTransition(new Fade());
        getWindow().setReturnTransition(new Fade());
        Bundle bundle = getIntent().getExtras();
        shareImage = (ImageView) findViewById(R.id.shareImage);
        int id = bundle.getInt("id",0);
        String transitionName = bundle.getString("transitionName");
        shareImage.setTransitionName(transitionName);
        shareImage.setImageBitmap(BitmapFactory.decodeResource(getResources(), data.get(id)));
    }
}
