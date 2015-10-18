package com.liwshuo.animation.transition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
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
        Transition exit;
        switch (view.getId()) {
            case R.id.explodeButton:
                 exit = new Explode();
                getWindow().setExitTransition(exit);
                break;
            case R.id.slideButton:
                break;
        }
        Intent intent = new Intent();
        intent.setClass(TransitionActivityA.this, TwoViewSwitchAnimationActivity.class);
        startActivity(intent);
    }
}
