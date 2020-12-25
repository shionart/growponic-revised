package com.project.testappgrowponic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_account.setOnClickListener {
            val intent =Intent(this, ProfileActivity::class.java)

            startActivity(intent)
        }

        button_belajar.setOnClickListener{
            val intent = Intent(this, BelajarActivity::class.java)

            startActivity(intent)
        }

        button_materi.setOnClickListener{
            val intent = Intent(this, MateriActivity::class.java)

            startActivity(intent)
        }

        button_jadwal.setOnClickListener{
            val intent = Intent(this, DaftarTanaman::class.java)

            startActivity(intent)
        }

        button_konsul.setOnClickListener{
            val intent = Intent(this, MessageActivity::class.java)

            startActivity(intent)
        }

//        button_admin.setOnClickListener {
//            val intent = Intent(this, AdminActivity::class.java)
//
//            startActivity(intent)
//        }

    }
}
