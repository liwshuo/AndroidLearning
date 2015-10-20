package com.liwshuo.animation.transition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liwshuo.animation.R;
import com.liwshuo.animation.util.ConstantValue;
import com.liwshuo.animation.util.Data;
import com.liwshuo.animation.util.ImageLoader;

import java.util.List;

/**
 * Created by liwshuo on 2015/10/20.
 */
public class ShareElementGridFragmentAdapter extends RecyclerView.Adapter {
    Activity context;
    List<Integer> data;

    public ShareElementGridFragmentAdapter(Activity context) {
        this.context = context;
        data = Data.getImageList();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.share_element_grid_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        System.out.println("onBindViewHolder");
        final ImageView shareImage = ((MyViewHolder) holder).shareImage;
        ImageLoader.getInstance(context).load(data.get(position), shareImage);
        shareImage.setTransitionName("image" + position);
        ((MyViewHolder) holder).imageName.setText("image" + position);
        shareImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt(ConstantValue.ID, position);
                bundle.putString(ConstantValue.TRANSITION_IMAGE_NAME, shareImage.getTransitionName());
                Fragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);
                detailFragment.setSharedElementEnterTransition(TransitionInflater.from(context).inflateTransition(R.transition.image_change));
                FragmentManager fragmentManager = context.getFragmentManager();
                Fragment gridFragment = fragmentManager.findFragmentByTag(ConstantValue.GRID_FRAGMENT_NAME);
                fragmentManager.beginTransaction().addToBackStack(ConstantValue.SHARE_ELEMENT_FRAGMENT_BACK_STACK)
                        .add(R.id.container, detailFragment).hide(gridFragment)
                        .addSharedElement(view, view.getTransitionName()).commit();
                System.out.println("fragment stack count:" + fragmentManager.getBackStackEntryCount());
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
