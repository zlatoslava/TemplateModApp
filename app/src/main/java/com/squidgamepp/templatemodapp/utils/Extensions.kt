package com.squidgamepp.templatemodapp.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.squidgamepp.templatemodapp.R
import java.lang.Exception

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_image)
        .error(R.drawable.ic_broken_image)
        .into(this)
}

fun ImageView.loadImage(@DrawableRes id: Int) {
    Glide.with(this)
        .asDrawable()
        .load(id)
        .centerCrop()
        .placeholder(R.drawable.ic_image)
        .error(R.drawable.ic_broken_image)
        .into(this)
}

fun ImageView.loadImageFitCenter(@DrawableRes id: Int) {
    Glide.with(this)
        .asDrawable()
        .load(id)
        .fitCenter()
        .placeholder(R.drawable.ic_image)
        .error(R.drawable.ic_broken_image)
        .into(this)
}

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.hide(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}

fun Context.openLink(link: String) {
    try {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    } catch (ex: Exception) {
        Toast.makeText(this, getString(R.string.invalid_link), Toast.LENGTH_SHORT)
            .show()
    }
}

fun Fragment.toastShort(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT)
        .show()
}

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            ) {
                return true
            }
        }
    } else {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            return true
        }
    }
    return false
}