package com.example.app_du_lich.models
data class Business(
    var id_business: Int,
    var id_user: String?,
    var id_location: Int?,
    var name_business: String?,
    var license_business: String?,
    var subscription_package_business: String?,
    var registration_status_business: Boolean?,
    var update_date_business: String?
)
