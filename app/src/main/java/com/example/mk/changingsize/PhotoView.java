package com.example.mk.changingsize;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PhotoView extends View {

    private Bitmap mBitmap;

    private Bitmap mChangedBitmap;

    private Rect mRect;

    private static int mCount;


    public PhotoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.android);
//        mBitmap = Bitmap.createScaledBitmap(mBitmap, mBitmap.getWidth(), mBitmap.getHeight(), true);

//        mRect = new Rect(0, getResources().getDisplayMetrics().heightPixels / 2 - mBitmap.getHeight(),
//                getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels / 2 + mBitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mCount == 0) {
            getBitmapRatio(mBitmap);

            int width = (getWidth() - mBitmap.getWidth()) /2;
            int height = (getHeight() - mBitmap.getHeight()) / 2;

            canvas.drawBitmap(mBitmap, width, height, null);
        }

        if (mCount == 1) {
            int width = (getWidth() - mChangedBitmap.getWidth()) /2;
            int height = (getHeight() - mChangedBitmap.getHeight()) / 2;

            canvas.drawBitmap(mChangedBitmap, width, height, null);
        } else {

        }
    }

    private void getBitmapRatio(Bitmap bitmap) {

        float ratio;

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        ratio = (float) width / (float) height;

        if (ratio > 1) {

           if (width > getWidth()) {
               width = getWidth();
               height = (int) (width / ratio);

               mBitmap =  Bitmap.createScaledBitmap(bitmap, width, height, true);
           } else {
               width = getWidth();
               height = (int) (width * ratio);

               mBitmap =  Bitmap.createScaledBitmap(bitmap, width, height, true);
           }
        } else {
            if (height > getHeight()) {
                height = getHeight();
                width = (int) (height * ratio);

                mBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
            } else {
                height = getHeight();
                width = (int) (height / ratio);

                mBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
            }
        }
    }

    public void cropSquare(int count) {
        mCount = count;

        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();

        if (width > height) {
            mChangedBitmap = Bitmap.createScaledBitmap(mBitmap, getWidth(), getWidth(), true);
        } else {
            mChangedBitmap = Bitmap.createScaledBitmap(mBitmap, getWidth(), getWidth(), true);
        }

        invalidate();
    }
}
