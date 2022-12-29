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
import com.example.finalproject.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        firestore = Firebase.firestore

        var registerButton = findViewById<Button>(R.id.modifyPwdButton)

        registerButton.setOnClickListener {
            var goToRegister = true
            val userName = findViewById<EditText>(R.id.userName).text.toString()
            val userId = findViewById<EditText>(R.id.userId).text.toString()
            val userPwd = findViewById<EditText>(R.id.userPwd).text.toString()
            val checkPwd = findViewById<EditText>(R.id.checkPwd).text.toString()

            if(userName.isEmpty()) {
                Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_LONG).show()
                goToRegister = false
            }
            if(userId.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_LONG).show()
                goToRegister = false
            }
            if(userPwd.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show()
                goToRegister = false
            }
            if(checkPwd.isEmpty()) {
                Toast.makeText(this, "비밀번호 확인을 입력해주세요", Toast.LENGTH_LONG).show()
                goToRegister = false
            }
            if(userPwd != checkPwd) {
                Toast.makeText(this, "비밀번호를 똑같이 입력해주세요", Toast.LENGTH_LONG).show()
                goToRegister = false
            }
            if(userPwd.length < 6) {
                Toast.makeText(this, "비밀번호를 6자리 이상으로 입력해주세요", Toast.LENGTH_LONG).show()
                goToRegister = false
            }
            if(goToRegister) { // 위에 조건 다 통과후 쓴 정보를 토대로 파이어베이스 회원가입 하기
                auth.createUserWithEmailAndPassword(userId, userPwd)
                    .addOnCompleteListener(this) {
                        if(it.isSuccessful) {
                            Toast.makeText(this, "회원가입이 되었습니다", Toast.LENGTH_LONG).show()
                            var userInfo = UserModel()
                            var uid = auth.currentUser?.uid
                            userInfo.uid = uid
                            userInfo.userName = userName
                            userInfo.userId = userId
                            userInfo.userPwd = userPwd
                            firestore?.collection("users")?.document(uid!!)?.set(userInfo)
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "회원가입에 실패하였습니다", Toast.LENGTH_LONG).show()
                        }
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