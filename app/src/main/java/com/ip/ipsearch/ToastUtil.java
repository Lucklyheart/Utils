package com.ip.ipsearch;

import android.content.Context;
import android.widget.Toast;

/**
 * 提示工具类
 */
public class ToastUtil {

    public static Toast toast = null;

    public static void show(Context ctx, String msg) {
        if (toast == null) {
            toast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
