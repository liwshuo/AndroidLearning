package com.liwshuo.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TwoViewSwitchAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageViewA;
    ImageView imageViewB;
    int mShortAnimationDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_view_switch_animation);
        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
        mShortAnimationDuration = 2000;
        imageViewA = (ImageView) findViewById(R.id.imageViewA);
        imageViewB = (ImageView) findViewById(R.id.imageViewB);
        imageViewA.setOnClickListener(this);
        imageViewB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewA:
                imageViewA.animate().alpha(0f).setDuration(mShortAnimationDuration).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        imageViewA.setVisibility(View.GONE);
                    }
                });
                imageViewB.setAlpha(0f);
                imageViewB.setVisibility(View.VISIBLE);
                imageViewB.animate().alpha(1f).setDuration(mShortAnimationDuration).setListener(null);
                break;
            case R.id.imageViewB:
                imageViewB.animate().alpha(0f).setDuration(mShortAnimationDuration).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        imageViewB.setVisibility(View.GONE);
                    }
                });
                imageViewA.setAlpha(0f);
                imageViewA.setVisibility(View.VISIBLE);
                imageViewA.animate().alpha(1f).setDuration(mShortAnimationDuration).setListener(null);
                break;
        }
    }
}
