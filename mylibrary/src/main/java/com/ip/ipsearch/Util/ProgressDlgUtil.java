package com.ip.ipsearch.Util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 进度条工具类
 */
public class ProgressDlgUtil {

    private static ProgressDialog progressDlg = null;

    /**
     * 启动进度条
     *
     * @param ctx 当前的activity
     */
    public static void show(Context ctx) {
        if (null == progressDlg) {
            progressDlg = new ProgressDialog(ctx);
            progressDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
            progressDlg.setCancelable(false);
        }
        progressDlg.show();
    }

    /**
     * 结束进度条
     */
    public static void dismiss() {
        if (null != progressDlg) {
            progressDlg.dismiss();
            progressDlg = null;
        }
    }
}
