package com.example.app_du_lich

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.app_du_lich.viewmodels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val pinkBackground = Color(0xFFFF69B4)

    val userViewModel: UserViewModel = viewModel()
    val loginResult = userViewModel.loginResult
    val loginError = userViewModel.loginError
    val isLoading = userViewModel.isLoading

    var showValidationError by remember { mutableStateOf(false) }

    // Điều hướng khi đăng nhập thành công
    LaunchedEffect(loginResult) {
        if (loginResult != null && loginResult.success) {
            navController.navigate("HomeScreen") {
                popUpTo("LoginScreen") { inclusive = true }
            }
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
            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Đăng Nhập",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange = {
                            phoneNumber = it
                            if (showValidationError) showValidationError = false
                        },
                        placeholder = { Text("Số điện thoại", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = if (showValidationError && phoneNumber.isEmpty()) Color.Red else Color.Gray,
                            unfocusedBorderColor = if (showValidationError && phoneNumber.isEmpty()) Color.Red else Color.Gray
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        isError = showValidationError && phoneNumber.isEmpty()
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            if (showValidationError) showValidationError = false
                        },
                        placeholder = { Text("Mật khẩu", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = if (showValidationError && password.isEmpty()) Color.Red else Color.Gray,
                            unfocusedBorderColor = if (showValidationError && password.isEmpty()) Color.Red else Color.Gray
                        ),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, contentDescription = null)
                            }
                        },
                        singleLine = true,
                        isError = showValidationError && password.isEmpty()
                    )

                    Text(
                        text = "Quên mật khẩu?",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("ForgotPasswordScreen")
                            }
                            .padding(vertical = 4.dp),
                        textAlign = TextAlign.End,
                        color = Color.Blue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )

                    // THÔNG BÁO LỖI
                    when {
                        showValidationError -> {
                            Text(
                                text = "Vui lòng điền đầy đủ thông tin",
                                color = Color.Red,
                                fontSize = 14.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                        loginError != null -> {
                            Text(
                                text = loginError,
                                color = Color.Red,
                                fontSize = 14.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            if (phoneNumber.isBlank() || password.isBlank()) {
                                showValidationError = true
                            } else {
                                showValidationError = false
                                userViewModel.loginUser(phoneNumber, password)
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(48.dp),
                        enabled = !isLoading
                    ) {
                        Text(
                            text = if (isLoading) "Đang đăng nhập..." else "Đăng Nhập",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Bạn chưa có tài khoản? Đăng ký",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
                    .clickable { navController.navigate("RegisterScreen") },
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 17.sp
            )
        }
    }
}
