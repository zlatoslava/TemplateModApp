package com.squidgamepp.templatemodapp.ui


import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.firebase.storage.FirebaseStorage
import com.squidgamepp.templatemodapp.R
import com.squidgamepp.templatemodapp.utils.downloadFile
import com.squidgamepp.templatemodapp.utils.isNetworkAvailable
import com.squidgamepp.templatemodapp.utils.openLink
import com.squidgamepp.templatemodapp.utils.toastShort
import kotlinx.android.synthetic.main.fragment_download.*


class DownloadFragment : Fragment() {

    //Название файла, будет отображаться у юзера при скачивании
    private val fileName by lazy { requireContext().getString(R.string.file_name) }

    //ссылка на файл
    private val fileUrl by lazy { requireContext().getString(R.string.download_link) }

    private val downloadLink by lazy { requireContext().getString(R.string.download_link) }

    private var addWatched = false
    private val adRequest = AdRequest.Builder().build()
    private var rewardedAd: RewardedAd? = null
    val fullScreenContentCallback: FullScreenContentCallback =
        object : FullScreenContentCallback() {
            override fun onAdShowedFullScreenContent() {
                // Code to be invoked when the ad showed full screen content.
            }

            override fun onAdDismissedFullScreenContent() {
                // Code to be invoked when the ad dismissed full screen content.
                if (!addWatched) {
                    toastShort(getString(R.string.toast_failed_show_ad))
                }
                loadAdd()
            }
        }

    private var uriToDownload: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadAdd()
    }

    private fun loadAdd() {
        addWatched = false
        RewardedAd.load(
            requireContext(),
            getString(R.string.key_reward),
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                    rewardedAd?.fullScreenContentCallback = fullScreenContentCallback
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_download, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdds()
        initDownload()
    }

    private fun initDownload() {
        btnDownload.setOnClickListener {
            if (requireContext().isNetworkAvailable()) {
                if (rewardedAd != null) {
                    rewardedAd?.show(
                        requireActivity()
                    ) {
                        addWatched = true
                        download()
                    }
                } else {
                    download()
                }
            } else toastShort(getString(R.string.no_connection))
        }
    }

    private fun download() {
        downloadFromDropbox()
    }

    private fun downloadFromDropbox() {
        requireContext().openLink(downloadLink)
    }

    private fun downloadFromFirebase() {
        val storage = FirebaseStorage.getInstance()
        val gsReference = storage.getReferenceFromUrl(fileUrl)

        gsReference.downloadUrl.addOnSuccessListener {
            uriToDownload = it.toString()
            if (hasWriteStoragePermission()) requireContext().downloadFile(it.toString(), fileName)
        }.addOnFailureListener {
            Toast.makeText(requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
        }
    }

    private fun hasWriteStoragePermission(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) return true else
            if (ActivityCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    111
                )

                return false
            }

        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            111 -> {
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    uriToDownload?.let { requireContext().downloadFile(it, fileName) }
                } else {
                    Toast.makeText(
                        requireContext(),
                        R.string.provide_permission,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return
            }
            else -> {
            }
        }
    }

    private fun initAdds() {
        adView.loadAd(adRequest)
    }
}