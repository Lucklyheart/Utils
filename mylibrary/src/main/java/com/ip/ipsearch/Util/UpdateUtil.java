package com.ip.ipsearch.Util;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;

/**
 * app 更新工具类
 */
public class UpdateUtil {

    private DownloadManager mDownloadManager;
    private Context mContext;
    private long mTaskId;

    public UpdateUtil(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * @param url 下载地址
     * @param appName app保存的名称
     */
    public void downLoad(String url, String appName) {
        mDownloadManager = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedOverRoaming(false);//禁止漫游下载
        //设置文件类型、可以在下载结束后自动打开文件
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String stringMime = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url));
        request.setMimeType(stringMime);//加入下载队列
        //通知栏显示
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setVisibleInDownloadsUi(true);
        //默认路径
        request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS, appName);
        //加入下载队列 返回下载ID、
        mTaskId = mDownloadManager.enqueue(request);
        mContext.registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

    }

    /**
     * 检测下载状态
     */
    private void checkDownLoad() {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(mTaskId);
        Cursor cursor = mDownloadManager.query(query);
        if (cursor.moveToNext()) {
            int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            switch (status) {
                case DownloadManager.STATUS_FAILED:
                    LogUtil.d("下载失败");
                    break;
                case DownloadManager.STATUS_PAUSED:
                    LogUtil.d("暂停下载");
                    break;
                case DownloadManager.STATUS_PENDING:
                    LogUtil.d("下载延迟");
                    break;
                case DownloadManager.STATUS_RUNNING:
                    LogUtil.d("正在下载");
                    break;
                case DownloadManager.STATUS_SUCCESSFUL:
                    LogUtil.d("下载完成");
                    installApk();
                    break;
            }
        }
        cursor.close();
    }

    /**
     * 安装
     */
    private void installApk() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = mDownloadManager.getUriForDownloadedFile(mTaskId);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        mContext.startActivity(intent);
        mContext.unregisterReceiver(receiver);
    }

    /**
     * 注册广播监听下载状态
     */
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkDownLoad();
        }
    };

}
