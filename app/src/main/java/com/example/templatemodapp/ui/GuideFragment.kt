package com.example.templatemodapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.templatemodapp.R
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.fragment_guide.adView


class GuideFragment : Fragment() {

    private val adRequest = AdRequest.Builder().build()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdds()
    }

    private fun initAdds() {
        adView.loadAd(adRequest)
    }
}