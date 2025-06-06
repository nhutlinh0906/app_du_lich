package com.example.app_du_lich.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(
    navController: NavController,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = Color.White,
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    tint = if (selectedTab == "home") Color.Red else Color.Black
                )
            },
            selected = selectedTab == "home",
            onClick = {
                navController.navigate("HomeScreen")
            }
        )
        NavigationBarItem(
            icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "hot",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedTab == "hot_place") Color.Red else Color.Black
                    )
                    Text(
                        "place",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedTab == "hot_place") Color.Red else Color.Black
                    )
                }
            },
            selected = selectedTab == "hot_place",
            onClick = {
                navController.navigate("HotPlacesScreen")
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = if (selectedTab == "profile") Color.Red else Color.Black
                )
            },
            selected = selectedTab == "profile",
            onClick = {navController.navigate("MyAccountScreen") }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = if (selectedTab == "settings") Color.Red else Color.Black
                )
            },
            selected = selectedTab == "settings",
            onClick = {navController.navigate("ProfileSettingsScreen") }
        )
    }
}
