package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        // 버튼 클릭 시 권한 허용 여부 묻는다
        ask.setOnClickListener {
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@PermissionActivity,
                android.Manifest.permission.CAMERA
            )   // Int
            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
                // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000    // 구별 위한 requestCode
                )
            } else {
                // 권한이 있는 경우
                Log.d("permissionsss", "권한이 이미 있음")
                // 휴대폰에서 권한 지우는 방법 : Settings - Apps - 나의 앱 - permissions - 권한 off
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 승낙
                Log.d("permissionsss", "승낙")
            } else {
                // 거부
                Log.d("permissionsss", "거부")
            }
        }
    }
}