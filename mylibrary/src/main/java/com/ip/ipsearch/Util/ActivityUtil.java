package com.ip.ipsearch.Util;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Activity栈管理器()
 */
public class ActivityUtil {

    private static Stack<Activity> activityStack = new Stack<>();

    private static ActivityUtil instance;

    private ActivityUtil() {
    }

    public static ActivityUtil getInstance() {
        if (instance == null) {
            synchronized (ActivityUtil.class) {
                if (instance == null) {
                    instance = new ActivityUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            synchronized (ActivityUtil.class) {
                if (activityStack == null) {
                    activityStack = new Stack<Activity>();
                }
            }
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后压入的）
     */
    public Activity currentActivity() {
        return activityStack == null ? null : activityStack.lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后压入的）
     */
    public void finishLastActivity() {
        if (activityStack != null && !activityStack.empty()) {
            Activity activity = activityStack.lastElement();
            finishActivity(activity);
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            if (activityStack != null && !activityStack.empty()) {
                activityStack.remove(activity);
                activity.finish();
            }
        }
    }

    /**
     * 结束所有的Activity
     */
    public void finishAllActivity() {
        if (activityStack != null && !activityStack.empty()) {

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
        finishAllActivity();
        System.exit(0);
    }
}
