package com.example.finalproject.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.finalproject.R
import com.example.finalproject.SplashActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class InfoFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        firestore = Firebase.firestore
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        val textName: TextView = view.findViewById(R.id.infoUserName)
        val textEmail: TextView = view.findViewById(R.id.infoUserEmail)

        firestore.collection("users")
            .whereEqualTo("uid", auth.uid)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    var userEmail = document["userId"]
                    var userName = document["userName"]
                    textName.text = userName as CharSequence?
                    textEmail.text = userEmail as CharSequence?
                }
        }
        val logout: Button? = view?.findViewById(R.id.logoutButton)
        logout?.setOnClickListener {
            auth.signOut()
            val intent = Intent(context, SplashActivity::class.java)
            startActivity(intent)
        }


        // 회원탈퇴
        val delete: Button? = view?.findViewById(R.id.deleteButton)
        delete?.setOnClickListener {

            val users = firestore.collection("users")
            val query: Query = users.whereEqualTo("uid", auth.uid)
            val task: Task<QuerySnapshot> = query.get()
            var uid = auth.currentUser?.uid

            // 현재 로그인한 유저의 회원정보 삭제
            task.addOnSuccessListener { querySnapshot ->
                val documents: MutableList<DocumentSnapshot> = querySnapshot.documents

                for (document in documents) {
                    users.document(uid!!).delete()
                }
            }
            // Authentication 에서 회원정보 삭제 후 SplashAct. 로 이동
            FirebaseAuth.getInstance().currentUser?.delete()
            val intent = Intent(context, SplashActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}