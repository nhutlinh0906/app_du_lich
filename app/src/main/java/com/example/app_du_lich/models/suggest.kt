package com.example.app_du_lich.models

data class Suggest(
    var id_suggest: Int,
    var id_search_history: Int?,
    var id_user: String?,
    var place_suggest: String?,
    var reason_suggest: String?,
    var similarity_score: String?,
    var feedback_on_suggestion: Boolean?,
    var created_date_suggest: String?
)


