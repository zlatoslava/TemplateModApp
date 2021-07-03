package com.example.templatemodapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.templatemodapp.R
import kotlinx.android.synthetic.main.fragment_main_menu.*


class MainMenuFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicks()
    }

    private fun initClicks() {
        btnInfo.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_infoFragment)
        }
        btnGuide.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_guideFragment)
        }
        btnScreen.setOnClickListener {

        }
        btnAllMods.setOnClickListener {

        }
        btnDownload.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_downloadFragment)
        }
    }
}