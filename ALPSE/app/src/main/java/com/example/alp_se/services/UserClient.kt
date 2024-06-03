package com.example.alp_se.services

import com.example.alp_se.model.Login
import com.example.alp_se.model.LoginToken
import com.example.alp_se.model.Route
import com.example.alp_se.model.User
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query


interface UserClient {

    @POST("login")
    suspend fun login(@Body login: Login) : LoginToken


    @GET("logout")
    suspend fun logout(@Header("Authorization") token: String)


    @GET("user")
    suspend fun getUser(@Header("Authorization") token: String): User

    @GET("routes")
    suspend fun getRoutes(): List<Route>

    @GET("currentroute")
    suspend fun getCurrentRoute(@Header("Authorization")token: String): Route?

    @PATCH("update-route")
    suspend fun updateRoute(@Header("Authorization")token: String,@Query("route_id") id: Int)

}