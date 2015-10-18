package com.liwshuo.animation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liwshuo.animation.transition.TransitionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button twoViewSwitchAnimationButton;
    Button transitionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twoViewSwitchAnimationButton = (Button) findViewById(R.id.twoViewSwitchAnimationButton);
        transitionButton = (Button) findViewById(R.id.transitionButton);
        twoViewSwitchAnimationButton.setOnClickListener(this);
        transitionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.twoViewSwitchAnimationButton:
                intent.setClass(MainActivity.this, TwoViewSwitchAnimationActivity.class);
                break;
            case R.id.transitionButton:
                intent.setClass(MainActivity.this, TransitionActivity.class);
                break;
        }
        startActivity(intent);
    }
}
