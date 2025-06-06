package com.example.app_du_lich.models
data class User(
    var id_user: String,
    var phone_user: String,
    var name_user: String,
    var password_user: String,
    var email_user: String?,
    var avata_user: String?,
    var address_user: String?,
    var hobbi_user: String?,
    var gender_user: Boolean?,  // tinyint(1) nullable, thường dùng cho boolean
    var status_user: String?,
    var data_create_user: String,  // timestamp không null
    var data_update_user: String?  // timestamp nullable
)
