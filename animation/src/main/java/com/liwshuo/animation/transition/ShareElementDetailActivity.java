package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.liwshuo.animation.R;
import com.liwshuo.animation.util.ConstantValue;
import com.liwshuo.animation.util.Data;
import com.liwshuo.animation.util.ImageLoader;
import com.liwshuo.animation.util.MemoryCache;

import java.util.ArrayList;
import java.util.List;

public class ShareElementDetailActivity extends AppCompatActivity {

    private ImageView shareImage;
    private TextView imageName;
    private List<Integer> data;
    private int id;
    private String transitionImageName;
    private String transitionTextName;
    private String transitionTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_detail);
        initData();
        setTransition();
        getDataFromList();
        initShareImage();
        initImageName();
    }

    private void initData() {
        data = Data.getImageList();
    }
    private void setTransition() {
        Transition imageViewTransiton = TransitionInflater.from(this).inflateTransition(R.transition.image_change);
        getWindow().setSharedElementEnterTransition(imageViewTransiton);
        getWindow().setSharedElementReturnTransition(imageViewTransiton);
        getWindow().setEnterTransition(new Fade());
        getWindow().setReturnTransition(new Fade());
    }

    private void getDataFromList() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt(ConstantValue.ID,0);
            transitionImageName = bundle.getString(ConstantValue.TRANSITION_IMAGE_NAME);
            transitionTextName = bundle.getString(ConstantValue.TRANSITION_TEXT_NAME);
            transitionTextValue = bundle.getString(ConstantValue.TRANSITION_TEXT_VALUE);
        }else {
            id = 0;
            transitionImageName = null;
            transitionTextName = null;
            transitionTextValue = "image";
        }
    }

    private void initShareImage() {
        shareImage = (ImageView) findViewById(R.id.shareImage);
        shareImage.setTransitionName(transitionImageName);
        ImageLoader.getInstance(this).load(data.get(id),shareImage);
    }

    private void initImageName() {
        imageName = (TextView) findViewById(R.id.imageName);
        imageName.setTransitionName(transitionTextName);
        imageName.setText(transitionTextValue);
    }
}
