package com.example.alp_se

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.alp_se.model.Route
import com.example.alp_se.model.User
import com.example.alp_se.ui.theme.ALPSETheme
import com.example.alp_se.viewmodel.HomeViewModel


@Composable
fun HomeView(destinations: List<Route>, current: Route, homeViewModel: HomeViewModel, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            items(destinations) { destination ->

                if (!destination.destination.equals("null") && destination.id != current.id) {
                    DestinationItem(destination, homeViewModel = homeViewModel, navController = navController)

                }
            }
        }
    }
}
@Composable
fun Blank(


) {


    Column(
        modifier = Modifier.fillMaxWidth().background(Color(0xFFF3F3F3)).fillMaxSize()

    ) {

    }


}

@Composable
fun DestinationItem(destination: Route, homeViewModel: HomeViewModel, navController: NavController) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color(0xFFFFA500))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "${destination.destination} (${destination.userCount}/${destination.max})",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "${destination.distance} km",
                fontSize = 14.sp,
                color = Color.White
            )
            Text(
                text = "School: ${destination.school}",
                fontSize = 14.sp,
                color = Color.White
            )
            Text(
                text = "Departure: ${destination.departure}",
                fontSize = 14.sp,
                color = Color.White
            )
        }
        Button(
            onClick = {
                if (destination.userCount < destination.max) {
                    homeViewModel.updateRoute(navController, destination.id)
                } else {
                    Toast.makeText(context, "Route already full", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFFFA500)
            )
        ) {
            Text(text = "Join")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(userName: String, homeViewModel: HomeViewModel, navController: NavController, dataStore: DataStore) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Welcome, $userName") },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = { homeViewModel.logout(navController = navController, dataStore = dataStore) }
                )
            }
        }
    )
}

@Composable
fun BottomBar() {
    BottomAppBar {
        Text(
            text = "Bottom Navigation",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

data class Route(
    val id: String,
    val destination: String,
    val school: String,
    val distance: Double,
    val userCount: Int,
    val max: Int,
    val departure: String,
    val driver: String
)

@Composable
fun CurrentRouteCard(route: Route, onCancelClick: () -> Unit) {
    if (route.destination == "null") {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(Color(0xFFD3D3D3))
        ) {
            Text(
                text = "Currently not join any route",
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    } else {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(Color(0xFFFFA500))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Current Route: ${route.destination}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Pickup at: ${route.school}",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = "Distance: ${route.distance} km",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = "Users: ${route.userCount}/${route.max}",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = "Departure: ${route.departure}",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = "Driver: ${route.driver}",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onCancelClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFFFFA500)
                    )
                ) {
                    Text(text = "Cancel")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeViewPreview(current: Route,listRoute: List<Route>, user: User, homeViewModel: HomeViewModel, navController: NavController, dataStore: DataStore) {
    ALPSETheme {
        Scaffold(
            topBar = { TopBar(userName = user.name, homeViewModel, navController, dataStore) },
            content = { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    Column {
                        CurrentRouteCard(route = current) {
                            homeViewModel.updateRoute(navController, 1)
                        }
                        HomeView(listRoute, current, homeViewModel, navController)
                    }
                }
            }
        )
    }
}
