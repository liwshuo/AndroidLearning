package com.liwshuo.animation.transition;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Window;

import com.liwshuo.animation.R;

public class TransitionActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_activity_b);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            Transition enter = new Explode();
            enter.setDuration(2000);
            enter.setStartDelay(1000);
            getWindow().setEnterTransition(enter);
            Transition exit = new Slide();
            getWindow().setExitTransition(exit);
            Transition shareElementEnter = new Explode();
            shareElementEnter.setDuration(2000);
            getWindow().setSharedElementEnterTransition(shareElementEnter);
        }else {

        }

    }
}
