package com.example.app_du_lich



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsOfUseScreen() {
    val pinkColor = Color(0xFFFF69B4)
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Chính Sách Bảo Mật",
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back click */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
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
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "CHÍNH SÁCH BẢO MẬT",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Ứng dụng của chúng tôi cam kết bảo vệ quyền riêng tư và dữ liệu cá nhân của người dùng. Chính sách này giải thích cách chúng tôi thu thập, sử dụng, lưu trữ và bảo vệ thông tin cá nhân của bạn.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "1. Thông tin chúng tôi thu thập",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Thông tin cá nhân: Họ tên, số điện thoại, email, giới tính, địa chỉ, ảnh đại diện, sở thích.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )
            Text(
                text = "- Thông tin đăng nhập: Mật khẩu (đã mã hóa), thiết bị sử dụng, thời gian đăng nhập.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )
            Text(
                text = "- Thông tin hoạt động: Lịch sử tìm kiếm, đánh giá, địa điểm yêu thích, lịch trình, phản hồi, nội dung chat.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "2. Mục đích sử dụng thông tin",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Cá nhân hóa trải nghiệm và cải thiện chất lượng dịch vụ.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )
            Text(
                text = "- Gửi thông báo, hỗ trợ kỹ thuật, xử lý vấn đề bảo mật.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "3. Chia sẻ thông tin với bên thứ ba",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Không chia sẻ thông tin cá nhân nếu không có sự đồng ý của người dùng, trừ khi có yêu cầu pháp lý hoặc kỹ thuật cần thiết.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "4. Bảo mật dữ liệu",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Dữ liệu được mã hóa, kiểm soát truy cập nội bộ, ghi nhật ký chỉnh sửa và đăng nhập để đảm bảo an toàn.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "5. Thời gian lưu trữ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Dữ liệu được lưu cho đến khi người dùng yêu cầu xóa hoặc tài khoản bị hủy.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "6. Quyền của người dùng",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Truy cập, chỉnh sửa, yêu cầu xóa dữ liệu, từ chối nhận quảng bá, gửi phản hồi.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "7. Cookie và công nghệ theo dõi",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Cookie có thể được sử dụng để lưu tùy chọn người dùng, cải thiện trải nghiệm và gợi ý địa điểm.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "8. Liên hệ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "- Mọi thắc mắc hoặc yêu cầu liên hệ qua email: donhutlinh0906@gmail.com hoặc hotline: 0385854427.",
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
