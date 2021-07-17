package com.pix_planet.templatemodapp.ui.data.models

data class Mod (
    val icon: Int,
    val name: String,
    val description: String? = null,
    val link: String
)