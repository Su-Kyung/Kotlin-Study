package com.example.myapplication

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 앱 전반에 대한 클래스 -> Application 상속
// Manifest 에 만들었음을 알려야 한다 (애플리케이션 등록)
class MasterApplication: Application() {

    lateinit var service: RetrofitService

    // Manifest 파일을 보면 application 이 activity 보다 상위에 있음을 알 수 있다
    // 따라서 같은 onCreate() 함수라고 할지라도 application 의 onCreate 함수가 더 먼저 호출된다
    // 즉, 이 안에서 retrofit 을 설정하게 되면 다른 activity 에서도 retrofit 을 가져다 쓸 수 있다
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        createRetrofit()
        // chrome://inspect/#devices 로 접속 -> 내 앱의 inspect 클릭
    }

    fun createRetrofit() {
        val header = Interceptor {  // interceptor -> 가로챔
            // 개조 : 헤더를 붙여준다
            val original = it.request()

            if (checkIsLogin()) {
                // null 이 아닌 경우에는 let 이하를 하겠다
                getUserToken()?.let {token ->   // token 안쓰면 it: String 즉, getUserToken 값이 들어온다
                    val request = original.newBuilder()
                        .header("Authorization", "token " + token)  // POST 시에 value 형식 반드시 지켜줘야 한다! (token 토큰값)
                        .build()
                    it.proceed(request)    // 개조한걸 내보낸다
                }
            } else {
                it.proceed(original)
            }
        }

        // 낚에채서 화면에 보여주고자 함
        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(RetrofitService::class.java)
    }

    // 로그인을 했는지 안했는지 -> 토큰의 유무로 판별
    fun checkIsLogin(): Boolean {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token != "null") return true
        else return false
    }

    fun getUserToken(): String? {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token != "null") return null
        else return token
    }
}