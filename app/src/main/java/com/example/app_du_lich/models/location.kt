data class Locationn(
    var id_locationn: String,
    var name_locationn: String,
    var address_locationn: String,
    var image_locationn: String?,
    var information_locationn: String?,
    var type_locationn: String,
    var map_locationn: String?,          // lưu tọa độ dưới dạng String (vd: "POINT(10 20)")
    var evaluate_locationn: Float?,
    var price_locationn: String?,
    var contact_locationn: String?,
    var open_locationn: String?,         // giờ mở cửa dạng String, vd: "08:00:00"
    var close_locationn: String?,        // giờ đóng cửa dạng String, vd: "22:00:00"
    var utilities_locationn: String?,
    var creator_locationn: Int?,
    var verified_locationn: Boolean?,
    var outstand_locationn: Boolean?,
    var update_locationn: String          // timestamp cũng có thể dùng String định dạng ISO
)


