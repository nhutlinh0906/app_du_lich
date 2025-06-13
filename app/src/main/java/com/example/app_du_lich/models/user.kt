package com.example.app_du_lich.models

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id_user") val idUser: Int,
    @SerializedName("phone_user") val phoneUser: String?,
    @SerializedName("name_user") val nameUser: String?,
    @SerializedName("password_user") val passwordUser: String?,
    @SerializedName("email_user") val emailUser: String?,
    @SerializedName("avata_user") val avataUser: String?,
    @SerializedName("address_user") val addressUser: String?,
    @SerializedName("hobbi_user") val hobbiUser: String?,
    @SerializedName("gender_user") val genderUser: String?,
    @SerializedName("status_user") val statusUser: String?,
    @SerializedName("data_create_user") val dataCreateUser: String?,
    @SerializedName("data_update_user") val dataUpdateUser: String?
)
data class ErrorResponse(
    val message: String
)
data class RegisterRequest(
    val phone_user: String,
    val password_user: String
)
data class RegisterResponse(
    val status: String,
    val message: String
)
data class SendOtpResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("otp_demo") val otpDemo: String? = null // Chỉ có khi test
)
data class VerifyOtpResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String
)
data class SendOtpRequest(
    @SerializedName("phone_user") val phoneUser: String
)
data class VerifyOtpRequest(
    @SerializedName("phone_user") val phoneUser: String,
    @SerializedName("otp") val otp: String
)
data class ForgotPasswordRequest(
    @SerializedName("phone_user") val phoneUser: String,
    @SerializedName("password_user") val passwordUser: String,
    @SerializedName("confirm_password_user") val confirmPasswordUser: String
)
data class ForgotPasswordResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String
)

data class UpdateResponse(
    val success: Boolean,
    val message: String
)