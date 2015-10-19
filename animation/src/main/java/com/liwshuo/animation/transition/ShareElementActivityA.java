package com.liwshuo.animation.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.liwshuo.animation.R;

public class ShareElementActivityA extends AppCompatActivity implements View.OnClickListener{

    ImageView imageViewA;
    ImageView imageViewB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_activity_a);
        imageViewA = (ImageView) findViewById(R.id.imageViewA);
        imageViewB = (ImageView) findViewById(R.id.imageViewB);
        imageViewA.setOnClickListener(this);
        imageViewB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.imageViewA:
                break;
            case R.id.imageViewB:
                break;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(ShareElementActivityA.this, new Pair<View, String>(imageViewA, "imageViewA")).toBundle();
        }else {

        }
        intent.setClass(ShareElementActivityA.this, ShareElementActivityB.class);

        startActivity(intent,bundle);
    }
}
