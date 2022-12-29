package com.example.finalproject

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.finalproject.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val bottomNavBar: BottomNavigationView by lazy {
        findViewById(R.id.bottom_navigation_bar)
    }
    private val frameContainer: FrameLayout by lazy {
        findViewById(R.id.framelayout_container)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 애플리케이션 실행 후 첫 화면
        supportFragmentManager.beginTransaction().add(
            frameContainer.id, HomeFragment()).commit()

            initNavBar()
    }

    // 프래그먼트 전환하는 함수
    private fun initNavBar() {
        bottomNavBar.setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.nav_home -> {
                        replaceFragment(HomeFragment())
                        true
                    }
                    R.id.nav_bulletin -> {
                        replaceFragment(BoardFragment())
                        true
                    }
                    R.id.nav_myInfo -> {
                        replaceFragment(InfoFragment())
                        true
                    }
                    else -> false
                }
            }
        }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(frameContainer.id, fragment).commit()
    }
}
