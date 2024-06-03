package com.example.alp_se.viewmodel

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_se.DataStore
import com.example.alp_se.ListScreen
import com.example.alp_se.services.MyContainer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    fun login(
        dataStore: DataStore,
        context: Context,
        email: String,
        password: String,
        navController: NavController
    ) {
        if (!isValidEmail(email)) {
            Toast.makeText(context, "Invalid email format", Toast.LENGTH_LONG).show()
            return
        }

        viewModelScope.launch {
            val token = MyContainer().myRepos.login(email, password)
            if (token.equals("Incorrect Password", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else if (token.equals("User not found", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else {
                dataStore.saveToken(token)

                dataStore.getToken.collect { token ->
                    if (token != null) {
                        MyContainer.ACCESS_TOKEN = token

                        MyContainer.user = MyContainer().myRepos.getUser(token)
                        //melihat token yang generated di log
                        Log.d("Token : ", MyContainer.ACCESS_TOKEN)

                        navController.navigate(ListScreen.Home.name) {
                            popUpTo(ListScreen.Login.name) { inclusive = true }
                        }
                    }
                }
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
