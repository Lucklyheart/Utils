package com.ip.ipsearch.Util;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Activity栈管理器
 */
public class ActivityUtil {

    public static Stack<Activity> activityStack;

    public static ActivityUtil instance;

    public static ActivityUtil getInstance() {

        if (instance == null) {
            instance = new ActivityUtil();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后压入的）
     */
    public void finishLastActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束所有的Activity
     */
    public void finishAllActivity() {
        if (activityStack != null) {

            for (int i = 0; i < activityStack.size(); i++) {
                Activity activity = activityStack.get(i);

                if (activity == null) {
                    continue;
                }

                LogUtil.e("ActivityName：" + activity);
                activity.finish();
            }
            activityStack.clear();
        }

    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            finishAllActivity();
            System.exit(0);
        } catch (Exception e) {
            LogUtil.e("退出失败：" + e);
        }
    }
}
