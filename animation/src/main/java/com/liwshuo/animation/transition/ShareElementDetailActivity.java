package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.liwshuo.animation.R;

import java.util.ArrayList;
import java.util.List;

public class ShareElementDetailActivity extends AppCompatActivity {

    ImageView shareImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_detail);
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.imagea);
        data.add(R.drawable.imageb);
        data.add(R.drawable.imagec);
        data.add(R.drawable.imaged);
        data.add(R.drawable.imagee);
        data.add(R.drawable.imagef);
        shareImage = (ImageView) findViewById(R.id.shareImage);
        int id = data.get(getIntent().getIntExtra("id",0));
        String transitionName = getIntent().getStringExtra("transitionName");
        shareImage.setTransitionName(transitionName);

        shareImage.setImageDrawable(this.getDrawable(id));

    }
}
