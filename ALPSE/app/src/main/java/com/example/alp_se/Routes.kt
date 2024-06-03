package com.example.alp_se


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alp_se.services.MyContainer
import com.example.alp_se.viewmodel.HomeUIState
import com.example.alp_se.viewmodel.HomeViewModel
import com.example.alp_se.viewmodel.LoginViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


enum class ListScreen() {

    Home,
    Login,


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun Routes() {

    val navController = rememberNavController()
    val dataStore = DataStore(LocalContext.current)


    val tokenState by dataStore.getToken.collectAsState(initial = null)


    GlobalScope.launch {
        dataStore.getToken.collect{
            if (it != null) {
                MyContainer.ACCESS_TOKEN = it
//                MyContainer.user = MyContainer().myRepos.getUser(MyContainer.ACCESS_TOKEN)
            }
        }
    }

    Scaffold (

        bottomBar = {


        }
    ){ it ->

        NavHost(
            navController = navController,
            startDestination = ListScreen.Login.name,
            modifier = Modifier.padding(it)

        ) {

            composable(ListScreen.Login.name) {


                if (MyContainer.ACCESS_TOKEN.isNullOrEmpty()) {

                    val loginViewModel: LoginViewModel = viewModel()


                    LoginView(loginViewModel = loginViewModel, dataStore =  dataStore, context = LocalContext.current, navController = navController)

                }
                else {


                    navController.navigate(ListScreen.Home.name)

                }
            }

            composable(ListScreen.Home.name) {

                val homeViewModel: HomeViewModel = viewModel()

                val status = homeViewModel.homeUIState

                when (status) {
                    is HomeUIState.Loading -> {

                        Blank()


                    }

                    is HomeUIState.Success -> {

                        HomeViewPreview(status.current,status.allRoute,user = status.user, homeViewModel, navController, dataStore)

                    }


                    is HomeUIState.Error -> {

                    }

                    else -> {}
                }

            }



            }




            }




            }



