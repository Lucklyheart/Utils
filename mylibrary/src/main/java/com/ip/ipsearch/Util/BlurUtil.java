package com.ip.ipsearch.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 *高斯模糊算法适用于api 17(Android 4.4)及其以上
 */
public class BlurUtil {

    private static final float SCALE = 1 / 8.0F;//default scale
    private static volatile BlurUtil singleton = null;
    private Bitmap mBitmap;
    private int mRadius = 0;
    private float mScale = SCALE;
    private Context mContext;


    /**
     * 单例
     *
     * @param context
     * @return
     */
    public static BlurUtil getInstance(Context context) {
        if (singleton == null) {
            synchronized (BlurUtil.class) {
                if (singleton == null) {
                    singleton = new BlurUtil(context);
                }
            }
        }
        return singleton;
    }

    private BlurUtil(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Bitmap blur() {
        if (mBitmap == null) {
            throw new RuntimeException("Bitmap can not be null");
        }
        if (mRadius == 0) {
            throw new RuntimeException("radius must > 0");
        }
        return rsBlur(mContext, mBitmap, mRadius, mScale);

    }

    /**
     * 模糊的Bitmap
     *
     * @param bitmap
     * @return
     */
    public BlurUtil bitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        return this;
    }

    /**
     * 缩放的系数
     *
     * @param scale
     * @return
     */
    public BlurUtil scale(int scale) {
        this.mScale = 1.0f / scale;
        return this;
    }

    /**
     * 模糊的半径，0-25
     *
     * @param radius
     * @return
     */
    public BlurUtil radius(int radius) {
        this.mRadius = radius;
        return this;
    }

    /**
     * 使用RenderScript 模糊图片
     *
     * @param context
     * @param source
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static Bitmap rsBlur(Context context, Bitmap source, int radius, float scale) {

        int width = Math.round(source.getWidth() * scale);
        int height = Math.round(source.getHeight() * scale);

        Bitmap inputBmp = Bitmap.createScaledBitmap(source, width, height, false);

        RenderScript renderScript = RenderScript.create(context);

        // Allocate memory for Renderscript to work with

        final Allocation input = Allocation.createFromBitmap(renderScript, inputBmp);
        final Allocation output = Allocation.createTyped(renderScript, input.getType());

        // Load up an instance of the specific script that we want to use.
        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        scriptIntrinsicBlur.setInput(input);

        // Set the blur radius
        scriptIntrinsicBlur.setRadius(radius);

        // Start the ScriptIntrinisicBlur
        scriptIntrinsicBlur.forEach(output);

        // Copy the output to the blurred bitmap
        output.copyTo(inputBmp);


        renderScript.destroy();

        return inputBmp;
    }
}
