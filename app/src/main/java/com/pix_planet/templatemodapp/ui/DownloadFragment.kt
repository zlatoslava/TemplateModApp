package com.pix_planet.templatemodapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pix_planet.templatemodapp.R
import com.pix_planet.templatemodapp.utils.openLink
import com.pix_planet.templatemodapp.utils.toastShort
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.fragment_download.*


class DownloadFragment : Fragment() {

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
            if (rewardedAd != null) {
                rewardedAd?.show(
                    requireActivity()
                ) {
                    addWatched = true
                    requireContext().openLink(getString(R.string.download_link))
                }
            } else {
                requireContext().openLink(getString(R.string.download_link))
            }
        }
    }

    private fun initAdds() {
        adView.loadAd(adRequest)
    }
}