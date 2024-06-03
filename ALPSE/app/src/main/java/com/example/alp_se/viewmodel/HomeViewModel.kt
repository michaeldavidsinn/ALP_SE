package com.example.alp_se.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_se.DataStore
import com.example.alp_se.ListScreen
import com.example.alp_se.model.Route
import com.example.alp_se.model.User
import com.example.alp_se.services.MyContainer
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


sealed interface HomeUIState {
    data class Success(val user: User, val allRoute: List<Route>, val current: Route) : HomeUIState
    object Error : HomeUIState
    object Loading : HomeUIState

}
class HomeViewModel: ViewModel(){

    private val _snackbarMessages = MutableSharedFlow<String>()
    val snackbarMessages = _snackbarMessages.asSharedFlow()

    var homeUIState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    lateinit var user: User
    lateinit var allRoute: List<Route>
    lateinit var current: Route


    init {
        load()
    }

    private fun load() {


        viewModelScope.launch{
            try {

                user = MyContainer().myRepos.getUser(MyContainer.ACCESS_TOKEN)
                allRoute = MyContainer().myRepos.getRoutes()
                current = MyContainer().myRepos.getCurrentRoute(MyContainer.ACCESS_TOKEN)!!
                homeUIState = HomeUIState.Success(user, allRoute,current)
            }catch(e: Exception){
                Log.d("FAILED", e.message.toString())
                homeUIState = HomeUIState.Error
            }
        }
    }


    public fun logout(
        navController: NavController,
        dataStore: DataStore
    ) {

        viewModelScope.launch {

            MyContainer().myRepos.logout(MyContainer.ACCESS_TOKEN)

            MyContainer.ACCESS_TOKEN = ""

            dataStore.saveToken(MyContainer.ACCESS_TOKEN)

            navController.navigate(ListScreen.Login.name)
        }

    }

    public fun updateRoute(
        navController: NavController,
        id: Int
    ) {
        viewModelScope.launch {

            MyContainer().myRepos.updateRoute(MyContainer.ACCESS_TOKEN, id )


            navController.navigate(ListScreen.Home.name)
        }
    }

    fun showSnackbarMessage(message: String) {
        viewModelScope.launch {
            _snackbarMessages.emit(message)
        }
    }



}