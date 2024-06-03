package com.example.alp_se.model

import com.google.gson.annotations.SerializedName


data class Route(
    @SerializedName("id") val id: Int,
    @SerializedName("destination") val destination: String,
    @SerializedName("max") val max: Int,
    @SerializedName("school") val school: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("user_count") val userCount: Int,
    @SerializedName("departure") val departure: String,
    @SerializedName("driver") val driver: String,

    )
