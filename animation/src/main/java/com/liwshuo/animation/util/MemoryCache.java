package com.liwshuo.animation.util;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by 硕 on 2015/10/21.
 */
public class MemoryCache {
    private static MemoryCache memoryCache;
    private LruCache<String, Bitmap> lruCache;

    private MemoryCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 4;
        lruCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public static MemoryCache getMemoryCache() {
        if (memoryCache == null) {
            synchronized (MemoryCache.class) {
                if (memoryCache == null) {
                    memoryCache = new MemoryCache();
                }
            }
        }
        return memoryCache;
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            lruCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return lruCache.get(key);
    }

}
