package com.squidgamepp.templatemodapp.utils

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import com.squidgamepp.templatemodapp.R

fun Context.downloadFile(
    fileUrl: String,
    fileName: String
) {
    val request = DownloadManager.Request(Uri.parse(fileUrl))
        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        .setTitle(fileName)
        .setMimeType("application/octet-stream")
        .setDescription(getString(R.string.app_name))
        .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)


    Toast.makeText(
        applicationContext,
        R.string.downloading,
        Toast.LENGTH_SHORT
    ).show()

    val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?

    downloadManager?.enqueue(request)
}