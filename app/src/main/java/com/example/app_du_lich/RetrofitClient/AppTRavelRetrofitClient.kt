package com.example.lapstore.api


import com.example.app_du_lich.api.EvaluateAPIService
import com.example.app_du_lich.api.EventAPIService
import com.example.app_du_lich.api.FavouriteAPIService
import com.example.app_du_lich.api.HistoryOfVisitAPIService
import com.example.app_du_lich.api.LocationnAPIService
import com.example.app_du_lich.api.MessageAPIService
import com.example.app_du_lich.api.NotificationAPIService
import com.example.app_du_lich.api.ProductAPIService
import com.example.app_du_lich.api.ScheduleAPIService
import com.example.app_du_lich.api.SearchHistoryAPIService
import com.example.app_du_lich.api.StatisticalAPIService
import com.example.app_du_lich.api.SuggestAPIService
import com.example.app_du_lich.api.SystemNotificationAPIService
import com.example.app_du_lich.api.TravelItineraryAPIService
import com.example.app_du_lich.api.TypeLocationAPIService
import com.example.app_du_lich.api.UserAPIService
import com.example.app_du_lich.api.VoiceAPIService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
//    const val BASE_URL = "http://chillcup.io.vn/ITLabRoomAPI/api/"
const val BASE_URL = "http://172.19.200.197/api_travel/api/"
}

object AppTRavelRetrofitClient {

    // locations : kết nối địa điểm

    val userAPIService: UserAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(UserAPIService::class.java)
    }
    val evaluateAPIService: EvaluateAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(EvaluateAPIService::class.java)
    }
    val eventAPIService: EventAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(EventAPIService::class.java)
    }
    val favouriteAPIService: FavouriteAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(FavouriteAPIService::class.java)
    }
    val historyOfVisitAPIService: HistoryOfVisitAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(HistoryOfVisitAPIService::class.java)
    }
    val locationnAPIService: LocationnAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(LocationnAPIService::class.java)
    }
    val messageAPIService: MessageAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(MessageAPIService::class.java)
    }
    val notificationAPIService: NotificationAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(NotificationAPIService::class.java)
    }
    val productAPIService: ProductAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ProductAPIService::class.java)
    }
    val scheduleAPIService: ScheduleAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ScheduleAPIService::class.java)
    }
    val searchHistoryAPIService: SearchHistoryAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(SearchHistoryAPIService::class.java)
    }
    val statisticalAPIService: StatisticalAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(StatisticalAPIService::class.java)
    }
    val suggestAPIService: SuggestAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(SuggestAPIService::class.java)
    }
    val systemNotificationAPIService: SystemNotificationAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(SystemNotificationAPIService::class.java)
    }
    val travelItineraryAPIService: TravelItineraryAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(TravelItineraryAPIService::class.java)
    }
    val typeLocationAPIService: TypeLocationAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(TypeLocationAPIService::class.java)
    }
    val voiceAPIService: VoiceAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(VoiceAPIService::class.java)
    }

}
// khởi tạo và cung cấp Retrofit client để gọi API. AppTRavelRetrofitClient.kt



