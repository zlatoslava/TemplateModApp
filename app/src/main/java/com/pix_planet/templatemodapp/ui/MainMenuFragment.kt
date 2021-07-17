package com.pix_planet.templatemodapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pix_planet.templatemodapp.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.android.synthetic.main.fragment_main_menu.*


class MainMenuFragment : Fragment() {

    private var mInterstitialAd: InterstitialAd? = null
    private val adRequest = AdRequest.Builder().build()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicks()
        initAdds()
    }

    private fun initAdds() {
        adView.loadAd(adRequest)
        InterstitialAd.load(
            requireContext(),
            getString(R.string.key_interstitial),
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                }
            })
    }

    private fun showInterstitialAdd() {
        mInterstitialAd?.show(requireActivity())
    }

    private fun initClicks() {
        btnInfo.setOnClickListener {
            showInterstitialAdd()
            findNavController().navigate(R.id.action_mainMenuFragment_to_infoFragment)
        }
        btnGuide.setOnClickListener {
            showInterstitialAdd()
            findNavController().navigate(R.id.action_mainMenuFragment_to_guideFragment)
        }
        btnScreen.setOnClickListener {
            showInterstitialAdd()
            findNavController().navigate(R.id.action_mainMenuFragment_to_screenshotsFragment)
        }
        btnAllMods.setOnClickListener {
            showInterstitialAdd()
            findNavController().navigate(R.id.action_mainMenuFragment_to_allModsFragment)
        }
        btnDownload.setOnClickListener {
            showInterstitialAdd()
            findNavController().navigate(R.id.action_mainMenuFragment_to_downloadFragment)
        }
    }
}