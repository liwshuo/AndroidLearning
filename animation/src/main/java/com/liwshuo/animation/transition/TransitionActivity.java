package com.liwshuo.animation.transition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liwshuo.animation.R;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener{
    Button twoActivityTransitionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        twoActivityTransitionButton = (Button) findViewById(R.id.twoActivityTransitionButton);
        twoActivityTransitionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.twoActivityTransitionButton:
                intent.setClass(TransitionActivity.this, TransitionActivityA.class);
                break;
         /*   case R.id.transitionButton:
                intent.setClass(TransitionActivity.this, TransitionActivity.class);
                break;*/
        }
        startActivity(intent);
    }
}
