
package com.example.app_du_lich.viewmodels

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val id_user: Int?,      // Có thể null nếu lỗi
    val name_user: String?
)
