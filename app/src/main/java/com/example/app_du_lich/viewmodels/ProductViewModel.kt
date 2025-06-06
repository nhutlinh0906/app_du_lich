package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Product
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    var productList by mutableStateOf<List<Product>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllProducts() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.productAPIService.getAllProducts()
                productList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("ProductViewModel", "Error fetching products", e)
            } finally {
                isLoading = false
            }
        }
    }
}
