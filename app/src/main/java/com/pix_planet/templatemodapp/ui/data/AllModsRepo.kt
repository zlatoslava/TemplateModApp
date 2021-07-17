package com.pix_planet.templatemodapp.ui.data

import com.pix_planet.templatemodapp.R
import com.pix_planet.templatemodapp.ui.data.models.Mod

object AllModsRepo {

    fun getAllModsList() = listOf(
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = R.drawable.screen_1
        ),
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = R.drawable.screen_2
        ),
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = R.drawable.screen_3
        ),
        Mod(
            name = "name",
            description = "description",
            link = "link",
            icon = R.drawable.screen_4
        )
    )
}