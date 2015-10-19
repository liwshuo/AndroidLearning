package com.liwshuo.animation.transition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
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

import com.liwshuo.animation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwshuo on 2015/10/19.
 */
public class ShareElementAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    Activity context;
    List<Integer> data;

    public ShareElementAdapter(Activity context) {
        this.context = context;
        data = new ArrayList<>();
        data.add(R.drawable.imagea);
        data.add(R.drawable.imageb);
        data.add(R.drawable.imagec);
        data.add(R.drawable.imaged);
        data.add(R.drawable.imagee);
        data.add(R.drawable.imagef);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.share_element_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        System.out.println(position);
        ((MyViewHolder) holder).shareImage.setImageDrawable(context.getDrawable(data.get(position)));
        ((MyViewHolder) holder).shareImage.setTransitionName("image" + position);
        ((MyViewHolder) holder).imageName.setText("iamge" + position);
        ((MyViewHolder) holder).shareImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, ShareElementDetailActivity.class);
                Bundle bundle = new Bundle();
            //    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //        bundle = ActivityOptions.makeSceneTransitionAnimation(context, new Pair<View, String>(view, "shareImage")).toBundle();
           //     }
                bundle.putString("transitionName", view.getTransitionName());
                bundle.putInt("id", position);
                Fragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);
                FragmentManager fragmentManager = context.getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, detailFragment).addSharedElement(view, view.getTransitionName()).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(context, ShareElementDetailActivity.class);
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(context, new Pair<View, String>(view, "shareImage")).toBundle();
        } else {

        }
   /*     switch (view.getId) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }*/
        context.startActivity(intent, bundle);
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
