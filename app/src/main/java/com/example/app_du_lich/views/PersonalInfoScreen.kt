package com.example.app_du_lich.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_du_lich.models.User
import com.example.app_du_lich.viewmodels.UserViewModel
import java.util.*

val pinkColor = Color(0xFFFF69B4)
val lightPinkColor = Color(0xFFFFFFFF)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInfoScreen(navController: NavController, viewModel: UserViewModel, userId: Int) {
    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Khác") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var deliveryAddress by remember { mutableStateOf("") }

    var showGenderDropdown by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    val genderOptions = listOf("Nam", "Nữ", "Khác")
    val scrollState = rememberScrollState()

    LaunchedEffect(userId) {
        viewModel.fetchUserById(userId)
    }

    LaunchedEffect(viewModel.user) {
        viewModel.user?.let { user ->
            fullName = user.nameUser ?: ""
            phoneNumber = user.phoneUser ?: ""
            birthDate = user.dataCreateUser ?: ""
            selectedGender = user.genderUser ?: "Khác"
            email = user.emailUser ?: ""
            address = user.addressUser ?: ""
            deliveryAddress = user.addressUser ?: ""
        }
    }

    if (showDatePicker) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = System.currentTimeMillis()
        )
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val calendar = Calendar.getInstance()
                            calendar.timeInMillis = millis
                            val day = calendar.get(Calendar.DAY_OF_MONTH)
                            val month = calendar.get(Calendar.MONTH) + 1
                            val year = calendar.get(Calendar.YEAR)
                            birthDate = String.format("%02d/%02d/%d", day, month, year)
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDatePicker = false }
                ) {
                    Text("Hủy")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Thông tin cá nhân",
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = pinkColor
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(lightPinkColor)
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FormField(
                label = "Họ và tên",
                isRequired = true,
                value = fullName,
                onValueChange = { fullName = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Ngày sinh", fontSize = 14.sp, color = Color(0xFF333333))
                    Text(" (*)", fontSize = 12.sp, color = Color.Red)
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = birthDate,
                    onValueChange = { birthDate = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showDatePicker = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = pinkColor,
                        unfocusedBorderColor = Color.LightGray
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = "Calendar",
                            tint = Color.Gray,
                            modifier = Modifier.clickable { showDatePicker = true }
                        )
                    },
                    readOnly = true
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Giới tính", fontSize = 14.sp, color = Color(0xFF333333))
                    Text(" (*)", fontSize = 12.sp, color = Color.Red)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box {
                    OutlinedTextField(
                        value = selectedGender,
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedBorderColor = pinkColor,
                            unfocusedBorderColor = Color.LightGray
                        ),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Dropdown",
                                tint = Color.Gray
                            )
                        },
                        readOnly = true
                    )
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .clickable { showGenderDropdown = true }
                    )
                    DropdownMenu(
                        expanded = showGenderDropdown,
                        onDismissRequest = { showGenderDropdown = false },
                        modifier = Modifier.width(IntrinsicSize.Max)
                    ) {
                        genderOptions.forEach { gender ->
                            DropdownMenuItem(
                                text = { Text(gender) },
                                onClick = {
                                    selectedGender = gender
                                    showGenderDropdown = false
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            FormField(
                label = "Email",
                isRequired = false,
                value = email,
                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            FormField(
                label = "Địa chỉ",
                isRequired = false,
                value = address,
                onValueChange = { address = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(32.dp))

            viewModel.updateSuccessMessage?.let {
                Text(text = it, color = Color.Green, fontSize = 14.sp, modifier = Modifier.padding(bottom = 8.dp))
            }
            viewModel.updateErrorMessage?.let {
                Text(text = it, color = Color.Red, fontSize = 14.sp, modifier = Modifier.padding(bottom = 8.dp))
            }

            Button(
                onClick = {
                    val user = User(
                        idUser = userId,
                        phoneUser = phoneNumber.takeIf { it.isNotBlank() },
                        nameUser = fullName.takeIf { it.isNotBlank() },
                        passwordUser = null,
                        emailUser = email.takeIf { it.isNotBlank() },
                        avataUser = null,
                        addressUser = address.takeIf { it.isNotBlank() },
                        hobbiUser = null,
                        genderUser = selectedGender.takeIf { it.isNotBlank() },
                        statusUser = null,
                        dataCreateUser = birthDate.takeIf { it.isNotBlank() },
                        dataUpdateUser = null
                    )
                    viewModel.updateUser(user)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = pinkColor),
                enabled = !viewModel.isLoading
            ) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
                } else {
                    Text(text = "Lưu", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormField(
    label: String,
    isRequired: Boolean,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = label, fontSize = 14.sp, color = Color(0xFF333333))
            if (isRequired) {
                Text(text = " (*)", fontSize = 12.sp, color = Color.Red)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = pinkColor,
                unfocusedBorderColor = Color.LightGray
            ),
            keyboardOptions = keyboardOptions
        )
    }
}
