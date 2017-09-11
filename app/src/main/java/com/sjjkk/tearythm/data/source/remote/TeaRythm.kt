package com.sjjkk.tearythm.data.source.remote

import com.sjjkk.tearythm.data.Data
import com.sjjkk.tearythm.data.Tea
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import retrofit2.http.*

/**
* Created by sjjkk on 2017/8/31.
*/

interface TeaRythmApi{

    @GET("/tea/{id}")
    @FormUrlEncoded
    fun getTea(@Query("id") id: String): Observable<Tea>

    @GET("/tea_answer")
    fun getTeaAnswer(@Query("age",encoded = true) age: String ,
                     @Query("taste",encoded = true) taste: String,
                     @Query("function_q",encoded = true)function_q: String): Observable<Data>

    @GET("/tea")
    fun getTeaList(): Observable<Data>

    @POST("/tea")
    fun commitTea(@Field("name") name:String,
                  @Field("function") function :String ,
                  @Field("age_up") age_up:String,
                  @Field("age_down") age_down:String,
                  @Field("taste_q")taste_q:String,
                  @Field("function_q")function_q:String):Observable<Status>
    @GET("/get_daily_tea")
    fun getDailyTea() : Observable<Tea>

    data class Status(var name: String)

    companion object {
        var BASE_URL: String = "http://123.206.8.125:10086/"
    }
}


