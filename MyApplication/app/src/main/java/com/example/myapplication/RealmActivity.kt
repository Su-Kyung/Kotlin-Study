package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.Realm.setDefaultConfiguration
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config : RealmConfiguration = RealmConfiguration.Builder()  // Builder 패턴에서 메소드 체이닝(.으로 함수 연결) 많이 사용
            .deleteRealmIfMigrationNeeded() // Migration : 데이터베이스를 sync 를 맞춘다(데이터베이스 관련 용어)
                                            // 이 함수는 Migration 해야하는 경우 데이터 다 삭제한다는 것
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        button_save.setOnClickListener {
            realm.executeTransaction {
                // < 하나의 작업 단위 >
                // A 테이블에서 데이터를 가져온다
                // B 테이블에서 데이터를 가져온다
                // C 테이블에서 데이터를 가져온다
                // 조합을 한다
                // D 테이블에 저장을 한다

                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }

        button_load.setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()    // 내가 가고자 하는 테이블에서 첫번째 줄 가져온다
                Log.d("data", "data : " + data)
            }
        }

        button_delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm() // 전부 지운다
                //it.where(School::class.java).findFirst().deleteFromRealm()  // 첫번째만 지운다
            }
        }
    }
}