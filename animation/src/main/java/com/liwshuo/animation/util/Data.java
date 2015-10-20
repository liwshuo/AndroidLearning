package com.liwshuo.animation.util;

import com.liwshuo.animation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwshuo on 2015/10/20.
 */
public class Data {
    static List<Integer> data = new ArrayList<>();
    static{
        data.add(R.drawable.imagea);
        data.add(R.drawable.imageb);
        data.add(R.drawable.imagec);
        data.add(R.drawable.imaged);
        data.add(R.drawable.imagee);
        data.add(R.drawable.imagef);
    }
    public static List<Integer> getImageList() {
        return data;
    }
}
