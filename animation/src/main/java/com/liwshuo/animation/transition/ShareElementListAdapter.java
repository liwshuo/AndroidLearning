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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwshuo on 2015/10/19.
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
        ImageView shareImage = ((MyViewHolder) holder).shareImage;
        ImageLoader.getInstance(context).load(data.get(position), shareImage);
        shareImage.setTransitionName("image" + position);
        ((MyViewHolder) holder).imageName.setText("iamge" + position);
        shareImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, ShareElementDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ConstantValue.TRANSITION_NAME, view.getTransitionName());
                System.out.println("id=" + position);
                bundle.putInt(ConstantValue.ID, position);
                Bundle options = ActivityOptions.makeSceneTransitionAnimation(context, new Pair<View, String>(view, view.getTransitionName())).toBundle();
                intent.putExtras(bundle);
                context.startActivity(intent, options);
             /*   bundle.putInt("id", position);
                Fragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);
                detailFragment.setSharedElementEnterTransition(TransitionInflater.from(context).inflateTransition(R.transition.image_change));
            //    detailFragment.setEnterTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.fade));
                FragmentManager fragmentManager = context.getFragmentManager();
                Fragment listFragment = fragmentManager.findFragmentByTag("listFragment");
                fragmentManager.beginTransaction().addToBackStack("shareElement")
                        .add(R.id.container, detailFragment).hide(listFragment).addSharedElement(view, view.getTransitionName()).commit();
                System.out.println("fragment stack count:" + fragmentManager.getBackStackEntryCount());*/
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
