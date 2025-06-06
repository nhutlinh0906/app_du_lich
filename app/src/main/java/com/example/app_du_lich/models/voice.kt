package com.example.app_du_lich.models

data class Voice(
    var id_voice: Int,
    var id_user: Int,
    var content_voice: String,
    var file_voice: String?,
    var transcription_voice: String?,
    var result_voice: String?,
    var odertype_voice: String?,
    var reliability_voice: Float?,
    var language_voice: String?,
    var imformation_voice: String?,
    var date_voice: String  // timestamp không null, có thể đổi sang LocalDateTime nếu cần
)


