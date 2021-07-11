package com.example.templatemodapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.templatemodapp.R
import com.example.templatemodapp.ui.data.ScreenshotsResource
import com.example.templatemodapp.utils.loadImageFitCenter
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.fragment_screenshots.*
import kotlinx.android.synthetic.main.fragment_screenshots.adView
import kotlinx.android.synthetic.main.item_screenshot.*


class ScreenshotsFragment : Fragment() {

    private val adRequest = AdRequest.Builder().build()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_screenshots, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initAdds()
    }

    private fun initViews() {
        val fragments = arrayListOf<Fragment>()
        val screenshots = ScreenshotsResource.getScreenshots()
        for (screenshot in screenshots) {
            val fragment = ScreenShotFragment.getInstance(screenshot)
            fragments.add(fragment)
        }
        val pagerAdapter = MyPagerAdapter(childFragmentManager, fragments)
        view_pager.adapter = pagerAdapter
        tab_layout.setupWithViewPager(view_pager, true)
    }
    private fun initAdds() {
        adView.loadAd(adRequest)
    }
}

class MyPagerAdapter(fm: FragmentManager, fragments: ArrayList<Fragment>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mFragments: ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    init {
        mFragments = fragments
    }
}

class ScreenShotFragment : Fragment() {

    private var resId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            resId = arguments?.getInt(RES_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_screenshot, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resId?.let { ivScreenshot.loadImageFitCenter(it) }
    }

    companion object {
        fun getInstance(resId: Int) = ScreenShotFragment().apply {
            arguments = Bundle().apply {
                putInt(RES_ID, resId)
            }
        }

        private const val RES_ID = "res_id"
    }
}