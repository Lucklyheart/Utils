package com.ip.ipsearch.Util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 手机组件调用工具类
 */
public class PhoneUtil {

    private PhoneUtil() {}

    /**
     * 调用系统发短信界面
     * @param activity    Activity
     * @param phoneNumber 手机号码
     * @param smsContent  短信内容
     */
    public static void sendMessage(Context activity, String phoneNumber, String smsContent) {
        if (smsContent == null || phoneNumber.length() < 4) {
            return;
        }
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", smsContent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }


    /**
     * 获取手机型号
     * @param context  上下文
     * @return   String
     */
    public static String getMobileModel(Context context) {
        try {
            String model = android.os.Build.MODEL;
            return model;
        } catch (Exception e) {
            return "未知！";
        }
    }

    /**
     * 获取手机品牌
     * @param context  上下文
     * @return  String
     */
    public static String getMobileBrand(Context context) {
        try {
            // android系统版本号
            String brand = android.os.Build.BRAND;
            return brand;
        } catch (Exception e) {
            return "未知";
        }
    }
}
