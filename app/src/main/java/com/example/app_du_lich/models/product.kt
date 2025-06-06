package com.example.app_du_lich.models
data class Product(
    var id_product: Int,
    var id_user: String,
    var name_product: String,
    var description_product: String,
    var price_product: Int,
    var discount_product: Int?,
    var image_product: String,
    var category_product: Int?,
    var date_create_product: String,
    var date_update_product: String
)
