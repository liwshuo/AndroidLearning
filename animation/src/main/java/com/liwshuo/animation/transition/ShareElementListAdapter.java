package com.liwshuo.animation.transition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liwshuo.animation.util.ConstantValue;
import com.liwshuo.animation.util.Data;
import com.liwshuo.animation.util.ImageLoader;
import com.liwshuo.animation.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwshuo on 2015/10/19.
 * ShareElementListActivity中的recycerview的adapter，负责展现图片和文本信息以及动态设置transition
 */
public class ShareElementListAdapter extends RecyclerView.Adapter {

    Activity context;
    List<Integer> data;

    public ShareElementListAdapter(Activity context) {
        this.context = context;
        data = Data.getImageList();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.share_element_list_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        System.out.println(position);
        final ImageView shareImage = ((MyViewHolder) holder).shareImage;
        final TextView imageName =  ((MyViewHolder) holder).imageName;
        ImageLoader.getInstance(context).load(data.get(position), shareImage);
        shareImage.setTransitionName("image" + position);
        imageName.setTransitionName("text" + position);
        ((MyViewHolder) holder).imageName.setText("image" + position);
        shareImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, ShareElementDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ConstantValue.TRANSITION_IMAGE_NAME, shareImage.getTransitionName());
                bundle.putString(ConstantValue.TRANSITION_TEXT_NAME, imageName.getTransitionName());
                bundle.putString(ConstantValue.TRANSITION_TEXT_VALUE, imageName.getText().toString());
                bundle.putInt(ConstantValue.ID, position);
                Bundle options = ActivityOptions.makeSceneTransitionAnimation(context,
                        new Pair<View, String>(shareImage, shareImage.getTransitionName()),
                        new Pair<View,String>(imageName, imageName.getTransitionName())).toBundle();
                intent.putExtras(bundle);
                context.startActivity(intent, options);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView shareImage;
        public TextView imageName;
        public MyViewHolder(View itemView) {
            super(itemView);
            shareImage = (ImageView) itemView.findViewById(R.id.shareImage);
            imageName = (TextView) itemView.findViewById(R.id.imageName);
        }
    }
}
