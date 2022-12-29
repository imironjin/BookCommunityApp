package com.example.finalproject.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.MainActivity
import com.example.finalproject.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {

            val loginId = findViewById<EditText>(R.id.loginId).text.toString()
            val loginPwd = findViewById<EditText>(R.id.loginPwd).text.toString()

            auth.signInWithEmailAndPassword(loginId, loginPwd)
                .addOnCompleteListener(this) {
                    if(it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        // 값 전달
                        //nextIntent.putExtra("email", loginId)
                        //nextIntent.putExtra("password", loginPwd)
                        //intent.putExtra("uid", auth.currentUser?.uid)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)

                        Toast.makeText(this, "환영합니다", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "아이디 혹은 비밀번호가 틀립니다", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
    // 키보드 외 화면 터치시 키보드 hidden
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }

}
