package com.example.app_du_lich

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app_du_lich.ui.theme.App_du_lichTheme
import com.example.app_du_lich.viewmodels.EvaluateViewModel
import com.example.app_du_lich.viewmodels.EventViewModel
import com.example.app_du_lich.viewmodels.FavouriteViewModel
import com.example.app_du_lich.viewmodels.HistoryOfVisitViewModel
import com.example.app_du_lich.viewmodels.LocationnViewModel
import com.example.app_du_lich.viewmodels.MessageViewModel
import com.example.app_du_lich.viewmodels.NotificationViewModel
import com.example.app_du_lich.viewmodels.ProductViewModel
import com.example.app_du_lich.viewmodels.ScheduleViewModel
import com.example.app_du_lich.viewmodels.SearchHistoryViewModel
import com.example.app_du_lich.viewmodels.StatisticalViewModel
import com.example.app_du_lich.viewmodels.SuggestViewModel
import com.example.app_du_lich.viewmodels.SystemNotificationViewModel
import com.example.app_du_lich.viewmodels.TravelItineraryViewModel
import com.example.app_du_lich.viewmodels.TypeLocationViewModel
import com.example.app_du_lich.viewmodels.UserViewModel
import com.example.app_du_lich.viewmodels.VoiceViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_du_lichTheme {
                val voiceViewModel: VoiceViewModel = viewModel()

                LaunchedEffect(Unit) {
                    voiceViewModel.getAllVoices()
                }

                HienDS(voiceViewModel)
            }
        }
    }
}
@Composable
fun HienDS(userViewModel: UserViewModel) {
    val users = userViewModel.userList
    val isLoading = userViewModel.isLoading
    val error = userViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách địa điểm",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(users) { user ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${user.id_user}")
                            Text(text = "Tên: ${user.name_user}")
                            Text(text = "SĐT: ${user.phone_user}")
                            Text(text = "Email: ${user.email_user ?: "Chưa có"}")
                            Text(text = "Địa chỉ: ${user.address_user ?: "Chưa có"}")
                            Text(text = "Giới tính: ${if (user.gender_user == true) "Nam" else if (user.gender_user == false) "Nữ" else "Không rõ"}")
                            Text(text = "Trạng thái: ${user.status_user ?: "Không rõ"}")
                            Text(text = "Ngày tạo: ${user.data_create_user}")
                            Text(text = "Ngày cập nhật: ${user.data_update_user ?: "Chưa cập nhật"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(evaluateViewModel: EvaluateViewModel) {
    val evaluates = evaluateViewModel.evaluateList
    val isLoading = evaluateViewModel.isLoading
    val error = evaluateViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách đánh giá",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(evaluates) { evaluate ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${evaluate.id_evaluate}")
                            Text(text = "ID User: ${evaluate.id_user}")
                            Text(text = "ID Địa điểm: ${evaluate.id_location}")
                            Text(text = "Điểm: ${evaluate.point_evaluate}")
                            Text(text = "Nội dung: ${evaluate.content_evaluate ?: "Không có"}")
                            Text(text = "Hình ảnh: ${evaluate.image_evaluate ?: "Không có"}")
                            Text(text = "Lượt thích: ${evaluate.likes_evaluate ?: 0}")
                            Text(text = "Phản hồi: ${evaluate.feedback_evaluate ?: "Không có"}")
                            Text(text = "Hữu ích: ${evaluate.useful_evaluate ?: 0}")
                            Text(text = "Báo cáo: ${if (evaluate.reported_evaluate == true) "Có" else "Không"}")
                            Text(text = "Lý do báo cáo: ${evaluate.reporting_evaluate ?: "Không có"}")
                            Text(text = "Kiểm duyệt: ${evaluate.censorship_status_evaluate ?: "Chưa duyệt"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(eventViewModel: EventViewModel) {
    val events = eventViewModel.eventList
    val isLoading = eventViewModel.isLoading
    val error = eventViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách sự kiện",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(events) { event ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID sự kiện: ${event.id_event}")
                            Text(text = "ID địa điểm: ${event.id_location ?: "Không có"}")
                            Text(text = "Tên sự kiện: ${event.name_event}")
                            Text(text = "Mô tả: ${event.describe_event ?: "Không có"}")
                            Text(text = "Ngày tạo: ${event.date_create_event}")
                            Text(text = "Ngày kết thúc: ${event.end_date_event}")
                            Text(text = "Hình ảnh: ${event.image_event ?: "Không có"}")
                            Text(text = "Đơn vị tổ chức: ${event.organizing_unit_event ?: "Không có"}")
                            Text(text = "Giá vé: ${event.ticket_price_event?.toString() ?: "Miễn phí"}")
                            Text(text = "Link đăng ký: ${event.registration_link_event ?: "Không có"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(favouriteViewModel: FavouriteViewModel) {
    val favourites = favouriteViewModel.favouriteList
    val isLoading = favouriteViewModel.isLoading
    val error = favouriteViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách yêu thích",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(favourites) { favourite ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID yêu thích: ${favourite.id_favourite}")
                            Text(text = "ID người dùng: ${favourite.id_user}")
                            Text(text = "ID địa điểm: ${favourite.id_place}")
                            Text(text = "Ghi chú: ${favourite.note_favourite}")
                            Text(text = "Thứ tự: ${favourite.numerical_order_favourite}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(historyViewModel: HistoryOfVisitViewModel) {
    val histories = historyViewModel.historyList
    val isLoading = historyViewModel.isLoading
    val error = historyViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách lịch sử thăm",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(histories) { history ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID lịch sử: ${history.id_history}")
                            Text(text = "ID User: ${history.id_user}")
                            Text(text = "ID Địa điểm: ${history.id_locationn}")
                            Text(text = "Ngày thăm: ${history.date_history}")
                            Text(text = "Thời gian thăm (phút): ${history.time_history ?: "Không rõ"}")
                            Text(text = "Ghi chú: ${history.note_history ?: "Không có"}")
                            Text(text = "Đánh giá: ${history.evaluate_history ?: "Chưa đánh giá"}")
                            Text(text = "Hình ảnh: ${history.image_history ?: "Không có"}")
                            Text(text = "Ngày tạo: ${history.creat_history}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(locationnViewModel: LocationnViewModel) {
    val locations = locationnViewModel.locationList
    val isLoading = locationnViewModel.isLoading
    val error = locationnViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách địa điểm",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(locations) { location ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${location.id_locationn}")
                            Text(text = "Tên: ${location.name_locationn}")
                            Text(text = "Địa chỉ: ${location.address_locationn}")
                            Text(text = "Ảnh: ${location.image_locationn ?: "Chưa có"}")
                            Text(text = "Thông tin: ${location.information_locationn ?: "Chưa có"}")
                            Text(text = "Loại: ${location.type_locationn}")
                            Text(text = "Bản đồ: ${location.map_locationn ?: "Chưa có"}")
                            Text(text = "Đánh giá: ${location.evaluate_locationn ?: "Chưa có"}")
                            Text(text = "Giá: ${location.price_locationn ?: "Chưa có"}")
                            Text(text = "Liên hệ: ${location.contact_locationn ?: "Chưa có"}")
                            Text(text = "Mở cửa: ${location.open_locationn ?: "Chưa có"}")
                            Text(text = "Đóng cửa: ${location.close_locationn ?: "Chưa có"}")
                            Text(text = "Tiện ích: ${location.utilities_locationn ?: "Chưa có"}")
                            Text(text = "Người tạo: ${location.creator_locationn ?: "Chưa có"}")
                            Text(text = "Đã xác thực: ${location.verified_locationn?.let { if(it) "Có" else "Không" } ?: "Chưa có"}")
                            Text(text = "Nổi bật: ${location.outstand_locationn?.let { if(it) "Có" else "Không" } ?: "Chưa có"}")
                            Text(text = "Cập nhật: ${location.update_locationn}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(messageViewModel: MessageViewModel) {
    val messages = messageViewModel.messageList
    val isLoading = messageViewModel.isLoading
    val error = messageViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách tin nhắn",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(messages) { message ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${message.id_message}")
                            Text(text = "ID User: ${message.id_user}")
                            Text(text = "Hỗ trợ: ${message.support_message ?: "Không có"}")
                            Text(text = "Nội dung: ${message.content_message}")
                            Text(text = "Loại tin nhắn: ${message.type_message ?: "Không có"}")
                            Text(text = "File đính kèm: ${message.file_message ?: "Không có"}")
                            Text(text = "Đã đọc: ${if (message.read_message == true) "Có" else "Chưa"}")
                            Text(text = "Ngày gửi: ${message.date_message}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(notificationViewModel: NotificationViewModel) {
    val notifications = notificationViewModel.notificationList
    val isLoading = notificationViewModel.isLoading
    val error = notificationViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách thông báo",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(notifications) { notification ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${notification.id_notification}")
                            Text(text = "ID User: ${notification.id_user}")
                            Text(text = "Tiêu đề: ${notification.title_notification}")
                            Text(text = "Nội dung: ${notification.content_notification}")
                            Text(text = "Loại thông báo: ${notification.type_notification}")
                            Text(text = "ID đối tượng: ${notification.id_object_notification}")
                            Text(text = "Link: ${notification.link_notification}")
                            Text(text = "Đã đọc: ${if (notification.read_notification) "Có" else "Chưa"}")
                            Text(text = "Ngày: ${notification.date_notification}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(productViewModel: ProductViewModel) {
    val products = productViewModel.productList
    val isLoading = productViewModel.isLoading
    val error = productViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách sản phẩm",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(products) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID sản phẩm: ${product.id_product}")
                            Text(text = "ID người dùng: ${product.id_user}")
                            Text(text = "Tên sản phẩm: ${product.name_product}")
                            Text(text = "Mô tả: ${product.description_product}")
                            Text(text = "Giá: ${product.price_product}")
                            Text(text = "Giảm giá: ${product.discount_product ?: 0}%")
                            Text(text = "Hình ảnh: ${product.image_product}")
                            Text(text = "Danh mục: ${product.category_product ?: "Không có"}")
                            Text(text = "Ngày tạo: ${product.date_create_product}")
                            Text(text = "Ngày cập nhật: ${product.date_update_product}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(scheduleViewModel: ScheduleViewModel) {
    val schedules = scheduleViewModel.scheduleList
    val isLoading = scheduleViewModel.isLoading
    val error = scheduleViewModel.errorMessage

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = "Danh sách lịch trình",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(schedules) { schedule ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("ID lịch trình: ${schedule.id_schedule}")
                            Text("ID người dùng: ${schedule.id_user}")
                            Text("ID địa điểm: ${schedule.id_location}")
                            Text("Tên lịch trình: ${schedule.name_schedule}")
                            Text("Ngày tạo: ${schedule.date_create_schedule}")
                            Text("Chi phí dự kiến: ${schedule.estimated_cost_schedule ?: "Không có"}")
                            Text("Ghi chú: ${schedule.note_schedule ?: "Không có"}")
                            Text("Thời gian dự kiến: ${schedule.estimated_time_schedule ?: "Không có"}")
                            Text("Phương tiện: ${schedule.vehicle_schedule ?: "Không có"}")
                            Text("Số người tham gia: ${schedule.number_of_greedy_people_schedule ?: "Không có"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(viewModel: SearchHistoryViewModel) {
    val histories = viewModel.searchHistoryList
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            text = "Lịch sử tìm kiếm",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(histories) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("ID: ${item.id_search_history}")
                            Text("ID người dùng: ${item.id_user}")
                            Text("Từ khóa: ${item.keywords_search_history}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(viewModel: StatisticalViewModel) {
    val list = viewModel.statisticalList
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách thống kê",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(list) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("ID thống kê: ${item.id_statistical}")
                            Text("Số người dùng: ${item.number_user_statistical ?: "Không có"}")
                            Text("Số địa điểm: ${item.number_locationn_statistical ?: "Không có"}")
                            Text("Số đánh giá: ${item.number_review_statistical ?: "Không có"}")
                            Text("Số phản hồi: ${item.number_responses_statistical ?: "Không có"}")
                            Text("Thời gian: ${item.time_statistical ?: "Không có"}")
                            Text("Chỉ số: ${item.index_statistical ?: "Không có"}")
                            Text("Phổ biến: ${item.popular_statistical ?: "Không có"}")
                            Text("Hoạt động: ${item.activity_statistical ?: "Không có"}")
                            Text("Ngày thống kê: ${item.date_statistical ?: "Không có"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(viewModel: SuggestViewModel) {
    val list = viewModel.suggestList
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách gợi ý",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(list) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("ID gợi ý: ${item.id_suggest}")
                            Text("ID lịch sử tìm kiếm: ${item.id_search_history ?: "Không có"}")
                            Text("ID người dùng: ${item.id_user ?: "Không có"}")
                            Text("Địa điểm gợi ý: ${item.place_suggest ?: "Không có"}")
                            Text("Lý do gợi ý: ${item.reason_suggest ?: "Không có"}")
                            Text("Điểm tương đồng: ${item.similarity_score ?: "Không có"}")
                            Text("Phản hồi: ${item.feedback_on_suggestion?.toString() ?: "Không có"}")
                            Text("Ngày tạo: ${item.created_date_suggest ?: "Không có"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(viewModel: SystemNotificationViewModel) {
    val list = viewModel.systemNotificationList
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Thông báo hệ thống",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(list) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("ID: ${item.id_systemnotification}")
                            Text("Tiêu đề: ${item.title_systemnotification}")
                            Text("Nội dung: ${item.content_systemnotification}")
                            Text("Loại: ${item.type_systemnotification}")
                            Text("ID người nhận: ${item.id_user ?: "Không có"}")
                            Text("Thời gian: ${item.time_systemnotification ?: "Không có"}")
                            Text("Trạng thái: ${item.status_systemnotification ?: "Không có"}")
                            Text("ID người tạo: ${item.id_create_systemnotification ?: "Không có"}")
                            Text("Ngày tạo: ${item.date_systemnotification ?: "Không có"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(viewModel: TravelItineraryViewModel) {
    val itineraries = viewModel.travelItineraryList
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách hành trình",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(itineraries) { itinerary ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${itinerary.id_travel_itinerary}")
                            Text(text = "ID User: ${itinerary.id_user}")
                            Text(text = "Tên hành trình: ${itinerary.name_itinerary ?: "Không có"}")
                            Text(text = "Điểm bắt đầu: ${itinerary.start_point_itinerary ?: "Không có"}")
                            Text(text = "Điểm kết thúc: ${itinerary.end_point_itinerary ?: "Không có"}")
                            Text(text = "Điểm nghỉ: ${itinerary.rest_stop_itinerary ?: "Không có"}")
                            Text(text = "Phương tiện: ${itinerary.vehicle_itinerary ?: "Không có"}")
                            Text(text = "Khoảng cách: ${itinerary.distance_itinerary?.toString() ?: "Không có"} km")
                            Text(text = "Thời gian dự kiến: ${itinerary.estimated_time_itinerary ?: "Không có"}")
                            Text(text = "Ngày cập nhật: ${itinerary.update_day_itinerary ?: "Không có"}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(viewModel: TypeLocationViewModel) {
    val typeLocations = viewModel.typeLocationList
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách loại địa điểm",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(typeLocations) { typeLocation ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${typeLocation.id_typelocation}")
                            Text(text = "Tên loại: ${typeLocation.name_typelocation}")
                            Text(text = "Mô tả: ${typeLocation.describe_typelocation ?: "Không có"}")
                            Text(text = "Icon: ${typeLocation.icon_typelocation ?: "Không có"}")
                            Text(text = "ID địa điểm: ${typeLocation.id_locationn}")
                            Text(text = "Trạng thái: ${if (typeLocation.status_typelocation) "Hoạt động" else "Không hoạt động"}")
                            Text(text = "Cập nhật: ${typeLocation.update_typelocation}")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HienDS(voiceViewModel: VoiceViewModel) {
    val voices = voiceViewModel.voiceList
    val isLoading = voiceViewModel.isLoading
    val error = voiceViewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Danh sách giọng nói",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Lỗi: $error", color = MaterialTheme.colorScheme.error)
            else -> LazyColumn {
                items(voices) { voice ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(text = "ID: ${voice.id_voice}")
                            Text(text = "ID User: ${voice.id_user}")
                            Text(text = "Nội dung: ${voice.content_voice}")
                            Text(text = "File: ${voice.file_voice ?: "Không có"}")
                            Text(text = "Phiên âm: ${voice.transcription_voice ?: "Không có"}")
                            Text(text = "Kết quả: ${voice.result_voice ?: "Không có"}")
                            Text(text = "Loại: ${voice.odertype_voice ?: "Không có"}")
                            Text(text = "Độ tin cậy: ${voice.reliability_voice ?: "Không có"}")
                            Text(text = "Ngôn ngữ: ${voice.language_voice ?: "Không có"}")
                            Text(text = "Thông tin: ${voice.imformation_voice ?: "Không có"}")
                            Text(text = "Ngày: ${voice.date_voice}")
                        }
                    }
                }
            }
        }
    }
}








