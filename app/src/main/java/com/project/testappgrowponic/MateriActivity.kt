package com.project.testappgrowponic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.testappgrowponic.belajarHidroponic.Tutorial6Activity
import com.project.testappgrowponic.tutorials.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_materi.*

class MateriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        menuCaraSatu.setOnClickListener {
            val intent = Intent(this, Tutorial1::class.java)

            startActivity(intent)
        }

        menuCaraDua.setOnClickListener {
            val intent = Intent(this, Tutorial2::class.java)

            startActivity(intent)
        }

        menuCaraTiga.setOnClickListener {
            val intent = Intent(this, Tutorial3::class.java)

            startActivity(intent)
        }

        menuCaraEmpat.setOnClickListener {
            val intent = Intent(this, Tutorial4::class.java)

            startActivity(intent)
        }

        menuCaraLima.setOnClickListener {
            val intent = Intent(this, Tutorial5::class.java)

            startActivity(intent)
        }

        menuCaraEnam.setOnClickListener {
            val intent = Intent(this, Tutorial6Activity::class.java)

            startActivity(intent)
        }
    }
}
