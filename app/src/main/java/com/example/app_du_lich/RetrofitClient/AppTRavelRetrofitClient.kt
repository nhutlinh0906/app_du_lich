package com.example.lapstore.api

import com.example.app_du_lich.api.*
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
    // Base URL cho emulator (localhost trên máy)
    const val BASE_URL = "http://10.0.2.2/api_travel/api/"
    // Nếu test trên thiết bị thật, thay bằng IP của máy chạy XAMPP, ví dụ:
    // const val BASE_URL = "http://192.168.x.x/api_travel/api/"
}

object AppTRavelRetrofitClient {
    // Tạo một instance Retrofit duy nhất
    private val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder()
            .build()

        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    // Khởi tạo các service
    val userAPIService: UserAPIService by lazy {
        retrofit.create(UserAPIService::class.java)
    }

    val evaluateAPIService: EvaluateAPIService by lazy {
        retrofit.create(EvaluateAPIService::class.java)
    }

    val eventAPIService: EventAPIService by lazy {
        retrofit.create(EventAPIService::class.java)
    }

    val favouriteAPIService: FavouriteAPIService by lazy {
        retrofit.create(FavouriteAPIService::class.java)
    }

    val historyOfVisitAPIService: HistoryOfVisitAPIService by lazy {
        retrofit.create(HistoryOfVisitAPIService::class.java)
    }

    val locationnAPIService: LocationnAPIService by lazy {
        retrofit.create(LocationnAPIService::class.java)
    }

    val messageAPIService: MessageAPIService by lazy {
        retrofit.create(MessageAPIService::class.java)
    }

    val notificationAPIService: NotificationAPIService by lazy {
        retrofit.create(NotificationAPIService::class.java)
    }

    val productAPIService: ProductAPIService by lazy {
        retrofit.create(ProductAPIService::class.java)
    }

    val scheduleAPIService: ScheduleAPIService by lazy {
        retrofit.create(ScheduleAPIService::class.java)
    }

    val searchHistoryAPIService: SearchHistoryAPIService by lazy {
        retrofit.create(SearchHistoryAPIService::class.java)
    }

    val statisticalAPIService: StatisticalAPIService by lazy {
        retrofit.create(StatisticalAPIService::class.java)
    }

    val suggestAPIService: SuggestAPIService by lazy {
        retrofit.create(SuggestAPIService::class.java)
    }

    val systemNotificationAPIService: SystemNotificationAPIService by lazy {
        retrofit.create(SystemNotificationAPIService::class.java)
    }

    val travelItineraryAPIService: TravelItineraryAPIService by lazy {
        retrofit.create(TravelItineraryAPIService::class.java)
    }

    val typeLocationAPIService: TypeLocationAPIService by lazy {
        retrofit.create(TypeLocationAPIService::class.java)
    }

    val voiceAPIService: VoiceAPIService by lazy {
        retrofit.create(VoiceAPIService::class.java)
    }
}