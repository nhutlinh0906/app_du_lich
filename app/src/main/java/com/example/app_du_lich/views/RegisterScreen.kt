package com.example.datn.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.viewmodels.UserViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: UserViewModel
) {
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var isOtpSent by remember { mutableStateOf(false) }
    var isOtpVerified by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val pinkBackground = Color(0xFFFF69B4)

    val registerError = viewModel.registerErrorMessage
    val registerSuccess = viewModel.registerSuccessMessage
    val sendOtpSuccess = viewModel.sendOtpSuccessMessage
    val sendOtpError = viewModel.sendOtpErrorMessage
    val verifyOtpSuccess = viewModel.verifyOtpSuccessMessage
    val verifyOtpError = viewModel.verifyOtpErrorMessage
    val otpDemo = viewModel.otpDemo

    // Reset lại OTP nếu thay đổi số điện thoại
    LaunchedEffect(phoneNumber) {
        isOtpSent = false
        isOtpVerified = false
        viewModel.clearOtpMessages()
    }

    // Điều hướng sau khi đăng ký thành công
    LaunchedEffect(registerSuccess) {
        if (!registerSuccess.isNullOrEmpty()) {
            delay(1500)
            navController.navigate("LoginScreen") {
                popUpTo("RegisterScreen") { inclusive = true }
            }
        }
    }

    // Đánh dấu đã gửi OTP
    LaunchedEffect(sendOtpSuccess) {
        if (!sendOtpSuccess.isNullOrEmpty()) {
            isOtpSent = true
        }
    }

    // Đánh dấu đã xác minh OTP
    LaunchedEffect(verifyOtpSuccess) {
        if (!verifyOtpSuccess.isNullOrEmpty()) {
            isOtpVerified = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(pinkBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 32.dp)
            ) {
                IconButton(onClick = {
                    navController.navigate("LoginScreen")
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
                Spacer(modifier = Modifier.width(16.dp))
            }

            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Đăng Ký", fontSize = 24.sp, fontWeight = FontWeight.Bold)

                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        placeholder = { Text("Số điện thoại (10 số)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors()
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("Mật khẩu") },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(icon, contentDescription = null)
                            }
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors()
                    )

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        placeholder = { Text("Nhập lại mật khẩu") },
                        visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val icon = if (confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                                Icon(icon, contentDescription = null)
                            }
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors()
                    )

                    if (!isOtpSent) {
                        Button(
                            onClick = {
                                if (phoneNumber.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                                    viewModel.registerErrorMessage = "Vui lòng điền đầy đủ thông tin"
                                    viewModel.registerSuccessMessage = null
                                } else if (password != confirmPassword) {
                                    viewModel.registerErrorMessage = "Mật khẩu không khớp"
                                    viewModel.registerSuccessMessage = null
                                } else if (!phoneNumber.matches(Regex("^[0-9]{10}$"))) {
                                    viewModel.registerErrorMessage = "Số điện thoại phải có đúng 10 số"
                                    viewModel.registerSuccessMessage = null
                                } else {
                                    viewModel.sendOtp(phoneNumber)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(0.6f)
                        ) {
                            Text("Gửi OTP", fontWeight = FontWeight.Bold)
                        }
                    }

                    sendOtpSuccess?.let { Text(it, color = Color.Green, fontSize = 14.sp) }
                    sendOtpError?.let { Text(it, color = Color.Red, fontSize = 14.sp) }
                    otpDemo?.let { Text("OTP: $it", color = Color.Blue, fontSize = 14.sp) }

                    if (isOtpSent && !isOtpVerified) {
                        OutlinedTextField(
                            value = otp,
                            onValueChange = { otp = it },
                            placeholder = { Text("Mã OTP (6 chữ số)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors()
                        )

                        Button(
                            onClick = {
                                if (otp.length != 6) {
                                    viewModel.verifyOtpErrorMessage = "Vui lòng nhập mã OTP 6 chữ số"
                                    viewModel.verifyOtpSuccessMessage = null
                                } else {
                                    viewModel.verifyOtp(phoneNumber, otp)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(0.6f)
                        ) {
                            Text("Xác thực OTP", fontWeight = FontWeight.Bold)
                        }

                        verifyOtpSuccess?.let { Text(it, color = Color.Green, fontSize = 14.sp) }
                        verifyOtpError?.let { Text(it, color = Color.Red, fontSize = 14.sp) }
                    }

                    if (isOtpVerified) {
                        Button(
                            onClick = {
                                viewModel.registerUser(phoneNumber, password, confirmPassword)
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(0.6f)
                        ) {
                            Text("Hoàn tất đăng ký", fontWeight = FontWeight.Bold)
                        }
                    }

                    registerError?.let { Text(it, color = Color.Red, fontSize = 14.sp) }
                    registerSuccess?.let { Text(it, color = Color.Green, fontSize = 14.sp) }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
