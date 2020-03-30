package com.ip.ipsearch.Util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListView;

/**
 * 常用的测量功能
 */
public class MeasureUtil {
    private MeasureUtil() {
    }

    /**
     * 获取控件的测量高度
     *
     * @param view 控件
     * @return 返回测量高度（MeasuredHeight）
     */
    public static int getMeasuredHeight(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view is null");
        }
        view.measure(0, 0);
        return view.getMeasuredHeight();
    }

    /**
     * 控件的高度
     *
     * @param view 控件View
     * @return 返回控件的高度
     */
    public static int getHeight(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view is null");
        }

        view.measure(0, 0);
        return view.getHeight();
    }

    /**
     * 获取控件的测量宽度
     *
     * @param view 控件
     * @return 返回控件的测量宽度
     */
    public static int getMeasuredWidth(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view is null");
        }

        view.measure(0, 0);
        return view.getMeasuredWidth();
    }

    /**
     * 获取控件的宽度
     *
     * @param view 控件
     * @return 返回控件的宽度
     */
    public static int getWidth(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view is null");
        }

        view.measure(0, 0);
        return view.getWidth();
    }

    /**
     * 设置高度
     *
     * @param view   控件
     * @param height 高度
     */
    public static void setHeight(View view, int height) {
        if (view == null || view.getLayoutParams() == null) {
            throw new IllegalArgumentException("View LayoutParams is null");
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = height;
        view.setLayoutParams(params);
    }

    /**
     * 设置View的宽度
     *
     * @param view  view
     * @param width 宽度
     */
    public static void setWidth(View view, int width) {
        if (view == null || view.getLayoutParams() == null) {
            throw new IllegalArgumentException("View LayoutParams is null");
        }

        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width;
        view.setLayoutParams(params);
    }

}
