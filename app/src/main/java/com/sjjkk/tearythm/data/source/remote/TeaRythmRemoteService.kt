package com.sjjkk.tearythm.data.source.remote

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.connection.ConnectInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by sjjkk on 2017/8/31.
 */
object TeaRythmRemoteService {
    private var retrofit: Retrofit? = null

    private var TeaRythm: TeaRythmApi? = null

    // TODO: 2017/6/8 Gson not yet
    val retrofitInstance: TeaRythmApi?
        get() {
            var interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            var client = OkHttpClient().newBuilder().addInterceptor(interceptor).build()


            val gson = GsonBuilder()
//                    .setDateFormat("yyyymmdd")
                    .create()
            if (retrofit != null)
                return retrofit!!.create(TeaRythmApi::class.java)
            else
                retrofit = Retrofit.Builder()
                        .baseUrl(TeaRythmApi.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client)
                        .build()
            return retrofit!!.create(TeaRythmApi::class.java)
        }


}