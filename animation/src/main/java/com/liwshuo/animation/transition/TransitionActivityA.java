package com.liwshuo.animation.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.liwshuo.animation.R;
import com.liwshuo.animation.TwoViewSwitchAnimationActivity;

public class TransitionActivityA extends AppCompatActivity implements View.OnClickListener{
    Button explodeButton;
    Button slideButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_activity_a);
        explodeButton = (Button) findViewById(R.id.explodeButton);
        slideButton = (Button) findViewById(R.id.slideButton);
        explodeButton.setOnClickListener(this);
        slideButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition exit;
            Transition reenter;
            ActivityOptions options;
            options = ActivityOptions.makeSceneTransitionAnimation(TransitionActivityA.this, new Pair<View, String>(explodeButton, "explodeButton"));
            bundle = options.toBundle();
            switch (view.getId()) {
                case R.id.explodeButton:
                    exit = new Explode();
                    exit.setDuration(2000);
                    getWindow().setExitTransition(exit);
                    reenter = new Slide();
                    ((Slide) reenter).setSlideEdge(Gravity.LEFT);
                    getWindow().setReenterTransition(reenter);
                    break;
                case R.id.slideButton:
                    break;
            }

        } else {
            // Implement this feature without material design
        }
        Intent intent = new Intent();
        intent.setClass(TransitionActivityA.this, TransitionActivityB.class);
        startActivity(intent, bundle);
    }
}
