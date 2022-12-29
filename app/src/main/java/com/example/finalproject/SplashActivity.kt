package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.auth.IntroActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 일정 시간 지연 이후 실행하기
        Handler(Looper.getMainLooper()).postDelayed({
            // 일정 시간 지난 후 MainActivity로 전환
            startActivity( Intent(this, IntroActivity::class.java))
            // 이동한 다음 뒤로 가기 방지
            finish()
        }, 2000) // 1초 후 실행
    }
}