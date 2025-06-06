package com.example.datn.ui.theme.navigation

sealed class Screen(val route: String) {
    object AddReferenceHistoryScreen : Screen("AddReferenceHistoryScreen")
    object ChatScreen : Screen("ChatScreen")
    object ContactScreen : Screen("ContactScreen")
    object DanhGiaBinhLuanScreen : Screen("DanhGiaBinhLuanScreen")
    object DeveloperProductsScreen : Screen("DeveloperProductsScreen")
    object DeveloperScreen : Screen("DeveloperScreen")
    object EditDeveloperInformationScreen : Screen("EditDeveloperInformationScreen")
    object EventScheduleScreen : Screen("EventScheduleScreen")
    object FavouriteScreen : Screen("FavouriteScreen")
    object FilterScreen : Screen("FilterScreen")
    object VoiceScreen : Screen("VoiceScreen")
    object HotPlacesScreen : Screen("HotPlacesScreen")
    object ItineraryDetailsScreen : Screen("ItineraryDetailsScreen")
    object LoginScreen : Screen("LoginScreen")
    object RegisterScreen : Screen("RegisterScreen")
    object LocationDetailsScreen : Screen("LocationDetailsScreen")
    object LocationManagementScreen:Screen("LocationManagementScreen")
    object LoginAlertScreen:Screen("LoginAlertScreen")
    object NotificationScreen:Screen("NotificationScreen")
    object PersonalScheduleScreen:Screen("PersonalScheduleScreen")
    object PlaceDetailScreen:Screen("PlaceDetailScreen")
    object ProfileSettingsScreen:Screen("ProfileSettingsScreen")
    object ReviewPostedContentScreen:Screen("ReviewPostedContentScreen")
    object RouteScreen:Screen("RouteScreen")
    object SuggestionsScreen:Screen("SuggestionsScreen")
    object TourSistoryDetails:Screen("TourSistoryDetails")
    object HomeScreen:Screen("HomeScreen")
    object ForgotPasswordScreen:Screen("ForgotPasswordScreen")
    object MyAccountScreen:Screen("MyAccountScreen")
    object PersonalInfoScreen:Screen("PersonalInfoScreen")
    object PersonalSchedule:Screen("PersonalSchedule")



}

