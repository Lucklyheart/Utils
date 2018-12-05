package com.ip.ipsearch.Util;

import android.util.Log;

import com.ip.ipsearch.mylibrary.BuildConfig;

/**
 * Log日志工具类
 */
public class LogUtil {

    private LogUtil() {
    }

    /**
     * 打印information日志
     *
     * @param "MyLog" 标签
     * @param msg     日志信息
     */
    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Log.i("MyLog", msg);
        }
    }

    /**
     * 打印information日志
     *
     * @param "MyLog"   标签
     * @param msg       日志信息
     * @param throwable 异常
     */
    public static void i(String msg, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.i("MyLog", msg, throwable);
        }
    }

    /**
     * 打印verbose日志
     *
     * @param "MyLog" 标签
     * @param msg     日志信息
     */
    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            Log.v("MyLog", msg);
        }
    }

    /**
     * 打印verbose日志
     *
     * @param "MyLog"   标签
     * @param msg       日志信息
     * @param throwable 异常
     */
    public static void v(String msg, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.v("MyLog", msg, throwable);
        }
    }

    /**
     * 打印debug信息
     *
     * @param "MyLog" 标签信息
     * @param msg     日志信息
     */
    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d("MyLog", msg);
        }
    }

    /**
     * 打印debug日志
     *
     * @param "MyLog"   标签信息
     * @param msg       日志信息
     * @param throwable 异常
     */
    public static void d(String msg, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.d("MyLog", msg, throwable);
        }
    }

    /**
     * 打印warn日志
     *
     * @param "MyLog" 标签信息
     * @param msg     日志信息
     */
    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            Log.w("MyLog", msg);
        }
    }

    /**
     * 打印warn日志
     *
     * @param "MyLog"   标签信息
     * @param msg       日志信息
     * @param throwable 异常
     */
    public static void w(String msg, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.w("MyLog", msg, throwable);
        }
    }

    /**
     * 打印error日志
     *
     * @param "MyLog" 标签
     * @param msg     日志信息
     */
    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            Log.e("MyLog", msg);
        }
    }

    /**
     * 打印error日志
     *
     * @param "MyLog"   标签
     * @param msg       日志信息
     * @param throwable 异常
     */
    public static void e(String msg, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.e("MyLog", msg, throwable);
        }
    }
}
