package com.liwshuo.animation.transition;

import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liwshuo.animation.R;

import java.util.ArrayList;
import java.util.List;


public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.imagea);
        data.add(R.drawable.imageb);
        data.add(R.drawable.imagec);
        data.add(R.drawable.imaged);
        data.add(R.drawable.imagee);
        data.add(R.drawable.imagef);
        Bundle bundle = getArguments();
        String transitionName = "";
        int id = 0;
        if (bundle != null) {
            transitionName = bundle.getString("transitionName");
            id = bundle.getInt("id");
        }
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView shareImage = (ImageView) view.findViewById(R.id.shareImage);
        shareImage.setTransitionName(transitionName);
        shareImage.setImageDrawable(getActivity().getDrawable(data.get(id)));
        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("share image click");
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });
        return view;
    }
}
