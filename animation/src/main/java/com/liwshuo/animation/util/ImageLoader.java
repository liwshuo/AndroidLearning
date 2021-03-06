package com.liwshuo.animation.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by 硕 on 2015/10/20.
 */
public class ImageLoader {
    private static ImageLoader imageLoader = null;
    private Context context;

    private ImageLoader(Context context) {
        this.context = context;
    }

    public static ImageLoader getInstance(Context context) {
        if (imageLoader == null) {
            synchronized (ImageLoader.class) {
                if (imageLoader == null) {
                    imageLoader = new ImageLoader(context);
                }
            }
        }
        return imageLoader;
    }

    public void load(int resId, ImageView imageView) {
        String imageKey = String.valueOf(resId);
        Bitmap bitmap = MemoryCache.getMemoryCache().getBitmapFromMemCache(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            final BitmapWorkerTask task = new BitmapWorkerTask(context, imageView);
            task.execute(String.valueOf(BitmapWorkerTask.LOCAL), String.valueOf(resId));
        }

    }


}
