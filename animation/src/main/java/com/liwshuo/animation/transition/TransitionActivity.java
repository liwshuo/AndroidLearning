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
    Button listButton;
    Button gridFragmentButton;
    Button twoFragmentTransitionButton;
    Button imageViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        twoActivityTransitionButton = (Button) findViewById(R.id.twoActivityTransitionButton);
        listButton = (Button) findViewById(R.id.listButton);
        twoActivityTransitionButton.setOnClickListener(this);
        listButton.setOnClickListener(this);
        imageViewButton = (Button) findViewById(R.id.imageViewButton);
        imageViewButton.setOnClickListener(this);
        gridFragmentButton = (Button) findViewById(R.id.gridFragmentButton);
        gridFragmentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.twoActivityTransitionButton:
                intent.setClass(TransitionActivity.this, TransitionActivityA.class);
                break;
            case R.id.listButton:
                intent.setClass(TransitionActivity.this, ShareElementListActivity.class);
                break;
            case R.id.imageViewButton:
                intent.setClass(TransitionActivity.this, ShareElementActivityA.class);
                break;
            case R.id.gridFragmentButton:
                intent.setClass(TransitionActivity.this, ShareElementGridFragmentActivity.class);
        }
        startActivity(intent);
    }
}
