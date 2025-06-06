package com.example.app_du_lich.models

data class Evaluate(
    var id_evaluate: Int,
    var id_user: Int,
    var id_location: Int,
    var point_evaluate: Int,
    var content_evaluate: String?,
    var image_evaluate: String?,
    var likes_evaluate: Int?,
    var feedback_evaluate: String?,
    var useful_evaluate: Int?,
    var reported_evaluate: Boolean?,
    var reporting_evaluate: String?,
    var censorship_status_evaluate: String?
)


