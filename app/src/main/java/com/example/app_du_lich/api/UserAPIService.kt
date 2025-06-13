package com.example.app_du_lich.api

import com.example.app_du_lich.models.*
import com.example.app_du_lich.viewmodels.LoginRequest
import com.example.app_du_lich.viewmodels.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface UserAPIService {

    // === ĐĂNG NHẬP ===
    @Headers("Content-Type: application/json")
    @POST("user/login.php")
    suspend fun loginUser(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    // === ĐỌC USER ===
    @GET("user/read_user.php")
    suspend fun getAllUsers(): List<User>

    @GET("user/read_one.php")
    suspend fun getUserById(@Query("id_user") id: Int): Response<User>

    // === ĐĂNG KÝ ===
    @Headers("Content-Type: application/json")
    @POST("user/register_user.php")
    suspend fun registerUser(
        @Body request: RegisterRequest
    ): Response<RegisterResponse>

    // === GỬI OTP ===
    @Headers("Content-Type: application/json")
    @POST("user/send_otp.php")
    suspend fun sendOtp(
        @Body request: SendOtpRequest
    ): Response<SendOtpResponse>

    // === XÁC THỰC OTP ===
    @Headers("Content-Type: application/json")
    @POST("user/verify_otp.php")
    suspend fun verifyOtp(
        @Body request: VerifyOtpRequest
    ): Response<VerifyOtpResponse>

    @Headers("Content-Type: application/json")
    @POST("user/forgot_password.php")
    suspend fun forgotPassword(
        @Body request: ForgotPasswordRequest
    ): Response<ForgotPasswordResponse>

    // === CẬP NHẬT USER ===
    @Headers("Content-Type: application/json")
    @POST("user/update_user.php")
    suspend fun updateUser(@Body user: User): Response<UpdateResponse>

}
