package com.liwshuo.animation.transition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.liwshuo.animation.R;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener{
    Button twoActivityTransitionButton;
    Button listViewButton;
    Button twoFragmentTransitionButton;
    Button imageViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        twoActivityTransitionButton = (Button) findViewById(R.id.twoActivityTransitionButton);
        listViewButton = (Button) findViewById(R.id.listViewButton);
        twoActivityTransitionButton.setOnClickListener(this);
        listViewButton.setOnClickListener(this);
        imageViewButton = (Button) findViewById(R.id.imageViewButton);
        imageViewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.twoActivityTransitionButton:
                intent.setClass(TransitionActivity.this, TransitionActivityA.class);
                break;
            case R.id.listViewButton:
                intent.setClass(TransitionActivity.this, ShareElementActivity.class);
                break;
            case R.id.imageViewButton:
                intent.setClass(TransitionActivity.this, ShareElementActivityA.class);
                break;
        }
        startActivity(intent);
    }
}
