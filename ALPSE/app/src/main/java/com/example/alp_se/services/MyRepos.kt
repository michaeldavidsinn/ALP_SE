package com.example.alp_se.services

import com.example.alp_se.model.Login
import com.example.alp_se.model.Route
import com.example.alp_se.model.User
import java.net.HttpURLConnection

class MyRepos(private val userClient: UserClient) {

    suspend fun login(email: String, password: String): String {

        val loginInfo = Login(email, password)

        val result = userClient.login(
            loginInfo
        )

        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result.data as String
        }

        return result.message;

    }

    suspend fun logout(token: String) {
        return userClient.logout(token)
    }

    suspend fun getUser(token: String): User {
        return userClient.getUser(token)
    }

    suspend fun getRoutes(): List<Route> {

        return userClient.getRoutes()

    }

    suspend fun getCurrentRoute(token: String): Route? {

        return userClient.getCurrentRoute(token)

    }

    suspend fun updateRoute(token: String, id:Int) {

        return userClient.updateRoute(token, id)

    }



}