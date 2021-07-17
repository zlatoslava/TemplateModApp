package com.pix_planet.templatemodapp.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.pix_planet.templatemodapp.R
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