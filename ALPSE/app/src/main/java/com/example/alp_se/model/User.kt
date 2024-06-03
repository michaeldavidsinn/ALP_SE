package com.example.alp_se.model;

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("email") val email: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("address") val address: String,
    @SerializedName("route") val route: Route?
    )
