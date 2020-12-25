package com.project.testappgrowponic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.testappgrowponic.belajarHidroponic.*
import kotlinx.android.synthetic.main.activity_belajar.*

class BelajarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belajar)


        menuKompetensi.setOnClickListener {
            val intent = Intent(this, KompetensiDasarActivity::class.java)

            startActivity(intent)
        }

        menuTentangHidroponic.setOnClickListener{
            val intent = Intent(this, TentangHidroponicActivity::class.java)

            startActivity(intent)
        }

        menuPertumbuhanPerkembangan.setOnClickListener {
            val intent = Intent(this, PertumbuhanPerkembanganActivity::class.java)

            startActivity(intent)
        }

        menuPemasaran.setOnClickListener {
            val intent = Intent(this, PemasaranActivity::class.java)

            startActivity(intent)
        }


    }
}
