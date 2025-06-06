package com.example.app_du_lich.api

import com.example.app_du_lich.models.Product
import retrofit2.http.GET

interface ProductAPIService {
    @GET("product/read_product.php")
    suspend fun getAllProducts(): List<Product>
}
