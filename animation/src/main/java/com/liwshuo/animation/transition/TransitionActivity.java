package com.liwshuo.animation.transition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liwshuo.animation.R;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener{
    Button twoActivityTransitionButton;
    Button shareElementButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        twoActivityTransitionButton = (Button) findViewById(R.id.twoActivityTransitionButton);
        shareElementButton = (Button) findViewById(R.id.shareElementButton);
        twoActivityTransitionButton.setOnClickListener(this);
        shareElementButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.twoActivityTransitionButton:
                intent.setClass(TransitionActivity.this, TransitionActivityA.class);
                break;
            case R.id.shareElementButton:
                intent.setClass(TransitionActivity.this, ShareElementActivity.class);
                break;
        }
        startActivity(intent);
    }
}
