package com.example.app_du_lich.models

data class Notification(
    var id_notification: Int,
    var id_user: Int,
    var title_notification: String,
    var content_notification: String,
    var type_notification: String,
    var id_object_notification: Int,
    var link_notification: String,
    var read_notification: Boolean,
    var date_notification: String
)

