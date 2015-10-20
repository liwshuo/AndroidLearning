package com.liwshuo.animation.transition;

import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liwshuo.animation.R;
import com.liwshuo.animation.util.ConstantValue;
import com.liwshuo.animation.util.Data;

import java.util.ArrayList;
import java.util.List;


public class DetailFragment extends Fragment {
    private List<Integer> data;
    int id;
    String transitionName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();
   //     setTransition();
        getDataFromGridFragment();
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initFragmentView(view);
        return view;
    }

    private void initData() {
        data = Data.getImageList();
    }

    private void setTransition() {
        Transition transition = TransitionInflater.from(getActivity()).inflateTransition(R.transition.image_change);
        setSharedElementEnterTransition(transition);

    }

    private void getDataFromGridFragment() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            transitionName = bundle.getString(ConstantValue.TRANSITION_IMAGE_NAME);
            id = bundle.getInt(ConstantValue.ID);
        }else {
            transitionName = null;
            id = 0;
        }
    }

    private void initFragmentView(View view) {
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
    }
}
