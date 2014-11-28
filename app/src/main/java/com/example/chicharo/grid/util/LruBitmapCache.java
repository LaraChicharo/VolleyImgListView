package com.example.chicharo.grid.util;

import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

public class LruBitmapCache extends LruCache<String, Bitmap> implements
        ImageCache {
    public static int getDefaultLruCacheSize() {
        //Log.d("Cache", "getDefaultLruCacheSize");
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        return cacheSize;
    }

    public LruBitmapCache() {
        this(getDefaultLruCacheSize());
        //Log.d("Cache", "LruBitmapCache");
    }

    public LruBitmapCache(int sizeInKiloBytes) {
        super(sizeInKiloBytes);
        //Log.d("Cache", "LruBitmapCache2");
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        //Log.d("Cache", "sizeOf");
        return value.getRowBytes() * value.getHeight() / 1024;
    }

    @Override
    public Bitmap getBitmap(String url) {
        //Log.d("Cache", "getBitmap");
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        //Log.d("Cache", "putBitmap");
        put(url, bitmap);
    }
}