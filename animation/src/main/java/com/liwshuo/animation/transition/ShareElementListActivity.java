package com.liwshuo.animation.transition;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.liwshuo.animation.R;

/**
 * 学习动态设置share element
 * 使用recyclerview的list模式展现图片和文本信息
 * 点击图片后，相应的图片和其文本信息会执行share element的transition动画
 */
public class ShareElementListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter shareElementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_list);
        setTransition();
        initRecyclerView();
    }

    /**
     * 设置transition属性
     */
    private void setTransition() {
        Transition imageViewTransiton = TransitionInflater.from(this).inflateTransition(R.transition.image_change);
        getWindow().setSharedElementExitTransition(imageViewTransiton);
        getWindow().setSharedElementReenterTransition(imageViewTransiton);
        getWindow().setExitTransition(new Fade());
        getWindow().setReenterTransition(new Fade());
    }

    /**
     * 初始化recyclerview，通过linearLayoutmanager设置为垂直的list模式
     */
    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        shareElementAdapter = new ShareElementListAdapter(this);
        recyclerView.setAdapter(shareElementAdapter);
    }
}
