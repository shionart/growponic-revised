package com.project.testappgrowponic.belajarHidroponic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.testappgrowponic.R
import com.project.testappgrowponic.util.StorageUtil
import kotlinx.android.synthetic.main.activity_pemasaran.*

class PemasaranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemasaran)

        val pem_1 = "/materi/pemasaran/Pem_1.png"
        val pem_3 = "/materi/pemasaran/Pem_3.png"
        val pem_4 = "/materi/pemasaran/Pem_4.png"
        val pem_7 = "/materi/pemasaran/idntimes.jpg"
        val pem_8 = "/materi/pemasaran/tips jual.png"



        //Load Gambar 1
        Glide.with(this)
            .load(StorageUtil.pathToReference(pem_1))
            .into(imageViewPem_1)

        // Load Gambar 3
        Glide.with(this)
            .load(StorageUtil.pathToReference(pem_3))
            .into(imageViewPem_3)

        // Load Gambar 4
        Glide.with(this)
            .load(StorageUtil.pathToReference(pem_4))
            .into(imageViewPem_4)

        // Load Gambar 7
        Glide.with(this)
            .load(StorageUtil.pathToReference(pem_7))
            .into(imageViewPem_7)

        // Load Gambar 8
        Glide.with(this)
            .load(StorageUtil.pathToReference(pem_8))
            .into(imageViewPem_8)

    }
}
