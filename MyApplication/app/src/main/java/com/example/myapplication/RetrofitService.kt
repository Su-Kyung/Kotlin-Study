package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*

// Retrofit 설명서에 따른다 (제작자가 interface 로 만들으라고 설명함)
interface RetrofitService {

    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST("json/students/")
    fun CreateStudents(
        @Body params: HashMap<String, Any>  // Key, Value(타입 고정 X)
    ): Call<PersonFromServer>

    @POST("json/students/")
    fun CreateStudentEasy(
        @Body person: PersonFromServer  // 해시가 아닌 객체를 넣어줌 -> 좀 더 간편하다
    ): Call<PersonFromServer>

    @FormUrlEncoded
    @POST("user/signup/")   // 이 API 요청
    fun register(
        @Field("username") username: String,
        @Field("password1") password1: String,
        @Field("password2") password2: String
    ): Call<User>   // 그에 대한 응답

    @FormUrlEncoded
    @POST("user/login/")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<User>
}