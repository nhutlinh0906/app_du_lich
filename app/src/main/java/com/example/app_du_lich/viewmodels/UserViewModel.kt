package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.*
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class UserViewModel : ViewModel() {

    var loginResult by mutableStateOf<LoginResponse?>(null)
        private set

    var loginError by mutableStateOf<String?>(null)
        private set

    var userList by mutableStateOf<List<User>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var user by mutableStateOf<User?>(null)
        private set

    var registerSuccessMessage by mutableStateOf<String?>(null)
    var registerErrorMessage by mutableStateOf<String?>(null)

    var sendOtpSuccessMessage by mutableStateOf<String?>(null)
        private set

    var sendOtpErrorMessage by mutableStateOf<String?>(null)
        private set

    var verifyOtpSuccessMessage by mutableStateOf<String?>(null)
    var verifyOtpErrorMessage by mutableStateOf<String?>(null)

    var otpDemo by mutableStateOf<String?>(null)
        private set

    // Thêm biến cho chức năng quên mật khẩu
    var forgotPasswordSuccessMessage by mutableStateOf<String?>(null)

    var forgotPasswordErrorMessage by mutableStateOf<String?>(null)

    var updateSuccessMessage by mutableStateOf<String?>(null)
        private set

    var updateErrorMessage by mutableStateOf<String?>(null)
        private set

    // Các hàm hiện có
    fun getAllUser() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.userAPIService.getAllUsers()
                userList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("UserViewModel", "Error fetching all users", e)
            } finally {
                isLoading = false
            }
        }
    }

    fun fetchUserById(id: Int) {
        isLoading = true
        viewModelScope.launch {
            try {
                val result = AppTRavelRetrofitClient.userAPIService.getUserById(id)
                if (result.isSuccessful) {
                    user = result.body()
                    errorMessage = null
                }
            } catch (e: Exception) {
                errorMessage = "Lỗi khi lấy dữ liệu người dùng: ${e.message}"
                Log.e("UserViewModel", "Lỗi khi lấy người dùng theo id: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun loginUser(phone: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = LoginRequest(phone, password)
                val response = AppTRavelRetrofitClient.userAPIService.loginUser(request)

                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.success) {
                        loginResult = body
                        loginError = null
                        Log.d("UserViewModel", "Login success: ${body.name_user}")
                    } else {
                        loginResult = null
                        loginError = body?.message ?: "Đăng nhập thất bại"
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    loginResult = null
                    loginError = try {
                        val jsonObject = JSONObject(errorBody)
                        jsonObject.getString("message")
                    } catch (e: Exception) {
                        "Lỗi server: ${response.code()}"
                    }
                }
            } catch (e: Exception) {
                loginError = "Lỗi mạng: ${e.localizedMessage}"
                loginResult = null
                Log.e("UserViewModel", "Login error", e)
            }
        }
    }

    fun registerUser(phone: String, password: String, confirmPassword: String) {
        if (phone.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            registerErrorMessage = "Vui lòng nhập đầy đủ thông tin"
            registerSuccessMessage = null
            return
        }

        if (password != confirmPassword) {
            registerErrorMessage = "Mật khẩu nhập lại không khớp"
            registerSuccessMessage = null
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = RegisterRequest(phone_user = phone, password_user = password)
                val response = AppTRavelRetrofitClient.userAPIService.registerUser(request)

                if (response.isSuccessful && response.body()?.status == "success") {
                    registerSuccessMessage = response.body()?.message ?: "Đăng ký thành công"
                    registerErrorMessage = null
                } else {
                    val errorBody = response.errorBody()?.string()
                    registerErrorMessage = try {
                        val json = JSONObject(errorBody)
                        json.getString("message")
                    } catch (e: Exception) {
                        response.body()?.message ?: "Đăng ký thất bại"
                    }
                    registerSuccessMessage = null
                }
            } catch (e: Exception) {
                registerErrorMessage = "Lỗi mạng: ${e.localizedMessage}"
                registerSuccessMessage = null
                Log.e("UserViewModel", "Register error", e)
            }
        }
    }

    fun sendOtp(phone: String) {
        if (phone.isBlank()) {
            sendOtpErrorMessage = "Vui lòng nhập số điện thoại"
            sendOtpSuccessMessage = null
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = SendOtpRequest(phoneUser = phone)
                val response = AppTRavelRetrofitClient.userAPIService.sendOtp(request)

                if (response.isSuccessful && response.body()?.success == true) {
                    sendOtpSuccessMessage = response.body()?.message ?: "OTP đã được gửi"
                    sendOtpErrorMessage = null
                    otpDemo = response.body()?.otpDemo
                    Log.d("UserViewModel", "Send OTP success: ${response.body()?.message}")
                } else {
                    val errorBody = response.errorBody()?.string()
                    sendOtpErrorMessage = try {
                        val json = JSONObject(errorBody)
                        json.getString("message")
                    } catch (e: Exception) {
                        response.body()?.message ?: "Gửi OTP thất bại"
                    }
                    sendOtpSuccessMessage = null
                }
            } catch (e: Exception) {
                sendOtpErrorMessage = "Lỗi mạng: ${e.localizedMessage}"
                sendOtpSuccessMessage = null
                Log.e("UserViewModel", "Send OTP error", e)
            }
        }
    }

    fun verifyOtp(phone: String, otp: String) {
        if (phone.isBlank() || otp.isBlank()) {
            verifyOtpErrorMessage = "Vui lòng nhập số điện thoại và mã OTP"
            verifyOtpSuccessMessage = null
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = VerifyOtpRequest(phoneUser = phone, otp = otp)
                val response = AppTRavelRetrofitClient.userAPIService.verifyOtp(request)

                if (response.isSuccessful && response.body()?.success == true) {
                    verifyOtpSuccessMessage = response.body()?.message ?: "Xác thực OTP thành công"
                    verifyOtpErrorMessage = null
                    Log.d("UserViewModel", "Verify OTP success: ${response.body()?.message}")
                } else {
                    val errorBody = response.errorBody()?.string()
                    verifyOtpErrorMessage = try {
                        val json = JSONObject(errorBody)
                        json.getString("message")
                    } catch (e: Exception) {
                        response.body()?.message ?: "Xác thực OTP thất bại"
                    }
                    verifyOtpSuccessMessage = null
                }
            } catch (e: Exception) {
                verifyOtpErrorMessage = "Lỗi mạng: ${e.localizedMessage}"
                verifyOtpSuccessMessage = null
                Log.e("UserViewModel", "Verify OTP error", e)
            }
        }
    }

    // Hàm quên mật khẩu
    fun forgotPassword(phone: String, password: String, confirmPassword: String) {
        if (phone.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            forgotPasswordErrorMessage = "Vui lòng nhập đầy đủ thông tin"
            forgotPasswordSuccessMessage = null
            return
        }

        if (password != confirmPassword) {
            forgotPasswordErrorMessage = "Mật khẩu nhập lại không khớp"
            forgotPasswordSuccessMessage = null
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = ForgotPasswordRequest(
                    phoneUser = phone,
                    passwordUser = password,
                    confirmPasswordUser = confirmPassword
                )
                val response = AppTRavelRetrofitClient.userAPIService.forgotPassword(request)

                if (response.isSuccessful && response.body()?.status == "success") {
                    forgotPasswordSuccessMessage = response.body()?.message ?: "Đặt lại mật khẩu thành công"
                    forgotPasswordErrorMessage = null
                } else {
                    val errorBody = response.errorBody()?.string()
                    forgotPasswordErrorMessage = try {
                        val json = JSONObject(errorBody)
                        json.getString("message")
                    } catch (e: Exception) {
                        response.body()?.message ?: "Đặt lại mật khẩu thất bại"
                    }
                    forgotPasswordSuccessMessage = null
                }
            } catch (e: Exception) {
                forgotPasswordErrorMessage = "Lỗi mạng: ${e.localizedMessage}"
                forgotPasswordSuccessMessage = null
                Log.e("UserViewModel", "Forgot password error", e)
            }
        }
    }
    fun clearOtpMessages() {
        sendOtpErrorMessage = null
        sendOtpSuccessMessage = null
        verifyOtpErrorMessage = null
        verifyOtpSuccessMessage = null
    }
    fun updateUser(user: User) {
        if (user.idUser == 0 || user.phoneUser.isNullOrBlank()) {
            updateErrorMessage = "Vui lòng cung cấp ID và số điện thoại"
            updateSuccessMessage = null
            return
        }

        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.userAPIService.updateUser(user)

                if (response.isSuccessful && response.body()?.success == true) {
                    updateSuccessMessage = response.body()?.message ?: "Cập nhật người dùng thành công"
                    updateErrorMessage = null
                    Log.d("UserViewModel", "Update user success: ${response.body()?.message}")
                } else {
                    val errorBody = response.errorBody()?.string()
                    updateErrorMessage = try {
                        val json = JSONObject(errorBody)
                        json.getString("message")
                    } catch (e: Exception) {
                        response.body()?.message ?: "Cập nhật người dùng thất bại"
                    }
                    updateSuccessMessage = null
                    Log.e("UserViewModel", "Update user failed: $errorBody")
                }
            } catch (e: Exception) {
                updateErrorMessage = "Lỗi mạng: ${e.localizedMessage}"
                updateSuccessMessage = null
                Log.e("UserViewModel", "Update user error", e)
            } finally {
                isLoading = false
            }
        }
    }
}