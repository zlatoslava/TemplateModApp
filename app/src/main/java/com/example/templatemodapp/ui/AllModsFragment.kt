package com.example.templatemodapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.templatemodapp.R
import com.example.templatemodapp.ui.adapters.AllModsRecyclerAdapter
import com.example.templatemodapp.ui.data.AllModsRepo
import com.example.templatemodapp.ui.data.models.Mod
import com.example.templatemodapp.utils.hide
import com.example.templatemodapp.utils.show
import kotlinx.android.synthetic.main.fragment_all_mods.*
import java.lang.Exception


class AllModsFragment : Fragment(), AllModsRecyclerAdapter.Listener {

    private val recAdapter = AllModsRecyclerAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_mods, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initData()
    }

    private fun initRecyclerView() = with(rvAllMods) {
        itemAnimator = null
        adapter = recAdapter
        layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun initData() {
        val list = AllModsRepo.getAllModsList()
        if(list.isEmpty()) {
            noMods.show()
            rvAllMods.hide()
        } else {
            recAdapter.setData(list)
        }
    }

    override fun onItemClicked(item: Mod) {
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
            startActivity(browserIntent)
        } catch(ex: Exception) {
            Toast.makeText(requireContext(), getString(R.string.invalid_link), Toast.LENGTH_SHORT).show()
        }
    }
}