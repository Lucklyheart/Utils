package com.ip.ipsearch.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

import java.util.HashMap;

public class VideoUtil {

    private VideoUtil() {
    }

    /**
     * 获取视频某一时间点儿图片
     *
     * @param context
     * @param videoUri
     * @param time     毫秒
     * @return
     */
    public static Bitmap getVideoFrameImg(Context context, String videoUri, long time) {
        Bitmap bitmap = null;
        MediaMetadataRetriever riever = new MediaMetadataRetriever();
        try {
            if (videoUri.startsWith("http")) {
                riever.setDataSource(videoUri, new HashMap<String, String>());
            } else {
                riever.setDataSource(context, Uri.parse(videoUri));
            }
            bitmap = riever.getFrameAtTime(time);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            riever.release();
        }
        return bitmap;
    }

    /**
     * 获取视频信息（时长、宽高、帧总数、角度、名字。作者。。。。）
     *
     * @param context
     * @param videoUri
     * @param keyCode  视频信息类型
     *                 例:MediaMetadataRetriever.METADATA_KEY_xxxxxx
     * @return
     */
    public static String getVideoValueByCode(Context context, String videoUri, int keyCode) {
        String value = null;
        MediaMetadataRetriever riever = new MediaMetadataRetriever();
        try {
            if (videoUri.startsWith("http")) {
                riever.setDataSource(videoUri, new HashMap<String, String>());
            } else {
                riever.setDataSource(context, Uri.parse(videoUri));
            }
            value = riever.extractMetadata(keyCode);
        } catch (Exception ex) {
        } finally {
            riever.release();
        }
        return value;
    }
}