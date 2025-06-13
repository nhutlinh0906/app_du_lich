package com.example.datn.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.app_du_lich.EvaluateScreen
import com.example.app_du_lich.LoginScreen
import com.example.app_du_lich.viewmodels.UserViewModel
import com.example.app_du_lich.views.ChatScreenChaS.kt.ChatScreen
import com.example.app_du_lich.views.ContactScreen.kt.ContactScreen
import com.example.app_du_lich.views.DeveloperProductScreen.kt.DeveloperProductScreen
import com.example.app_du_lich.views.DeveloperScreen
import com.example.app_du_lich.views.EditDeveloperInformationScreen
import com.example.app_du_lich.views.EventScheduleScreen
import com.example.app_du_lich.views.FavouriteScreen
import com.example.app_du_lich.views.LocationManagementScreen
import com.example.app_du_lich.views.MyAccountScreen
import com.example.app_du_lich.views.PersonalInfoScreen
import com.example.app_du_lich.views.RouteScreen
import com.example.myapplication.ui.theme.HomeScreen
import com.example.myapplication.ui.theme.NotificationScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "LoginScreen") {
        composable("LoginScreen") {
            LoginScreen(navController = navController)
        }
        composable("RegisterScreen") {
            val userViewModel: UserViewModel = viewModel()
            RegisterScreen(navController = navController, viewModel = userViewModel)
        }

        composable("ChatScreen") {
            ChatScreen(navController = navController)
        }
        composable("HomeScreen") {
            HomeScreen(navController = navController)
        }

        composable("ContactScreen") {
            ContactScreen(navController = navController)
        }

        composable("DeveloperProductsScreen") {
            DeveloperProductScreen(navController = navController)
        }
        composable("DeveloperScreen") {
            DeveloperScreen(navController = navController)
        }
        composable("EditDeveloperInformationScreen") {
            EditDeveloperInformationScreen(navController = navController)
        }
        composable("EventScheduleScreen") {
            EventScheduleScreen(navController = navController)
        }
        composable("FavouriteScreen") {
            FavouriteScreen(navController = navController)
        }
        composable("FilterScreen") {
            FilterScreen(navController = navController)
        }
        composable("VoiceScreen") {
            VoiceScreen(navController = navController)
        }
        composable("HotPlacesScreen") {
            HotPlacesScreen(navController = navController)
        }
        composable("ItineraryDetailsScreen") {
            ItineraryDetailsScreen(navController = navController)
        }
        composable("LocationDetailsScreen") {
            LocationDetailsScreen(navController = navController)
        }
        composable("LocationManagementScreen") {
            LocationManagementScreen(navController = navController)
        }
        composable("LoginAlertScreen") {
            LoginAlertScreen(navController = navController)
        }
        composable("NotificationScreen") {
            NotificationScreen(navController = navController)
        }
        // composable("PersonalScheduleScreen") {
        //    PersonalScheduleScreen(navController = navController)
        //  }

        composable("ProfileSettingsScreen") {
            ProfileSettingsScreen(navController = navController)
        }
        composable("ReviewPostedContentScreen") {
            ReviewPostedContentScreen(navController = navController)
        }
        composable("RouteScreen") {
            RouteScreen(navController = navController)
        }
        composable("SuggestionsScreen") {
            SuggestionsScreen(navController = navController)
        }
        composable("TourHistoryDetails") {
            TourHistoryDetails  (navController = navController)
        }
        composable("ForgotPasswordScreen") {
            ForgotPasswordScreen(navController = navController)
        }
        composable("MyAccountScreen") {
            val userViewModel: UserViewModel = viewModel()
            MyAccountScreen(navController = navController, viewModel = userViewModel)
        }
        composable("ForgotPasswordScreen") {
            ForgotPasswordScreen(navController = navController)
        }
        composable(
            route = "PersonalInfoScreen/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) {
            val userViewModel: UserViewModel = viewModel()
            val userId = it.arguments?.getInt("userId") ?: 0
            PersonalInfoScreen(
                navController = navController,
                viewModel = userViewModel,
                userId = userId
            )
        }
        composable("EvaluateScreen") {
            EvaluateScreen(navController = navController)
        }

    }
}




