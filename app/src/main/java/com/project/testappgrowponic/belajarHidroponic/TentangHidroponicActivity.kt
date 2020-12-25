package com.project.testappgrowponic.belajarHidroponic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.testappgrowponic.R
import com.project.testappgrowponic.util.StorageUtil
import kotlinx.android.synthetic.main.activity_tentang_hidroponik.*

class TentangHidroponicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang_hidroponik)

        val hidro_1 = "/materi/tentang-hidroponik/Hidro_1.png"
        val hidro_2 = "/materi/tentang-hidroponik/Hidro_2.png"
        val hidro_3 = "/materi/tentang-hidroponik/Hidro_3.png"
        val hidro_4 = "/materi/tentang-hidroponik/Hidro_4.png"
        val hidro_5 = "/materi/tentang-hidroponik/Hidro_5.png"
        val hidro_6 = "/materi/tentang-hidroponik/Hidro_6.png"
        val hidro_8 = "/materi/tentang-hidroponik/Kit plastik.png"
        val hidro_9 = "/materi/tentang-hidroponik/tabel biaya.png"


        // Load Gambar 1
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_1))
            .into(imageViewHidro_1)

        // Load Gambar 2
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_2))
            .into(imageViewHidro_2)

        // Load Gambar 3
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_3))
            .into(imageViewHidro_3)

        // Load Gambar 4
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_4))
            .into(imageViewHidro_4)

        // Load Gambar 5
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_5))
            .into(imageViewHidro_5)

        // Load Gambar 6
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_6))
            .into(imageViewHidro_6)

        //Load Gambar 8
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_8))
            .into(imageViewHidro_8)

        //Load Gambar 9
        Glide.with(this)
            .load(StorageUtil.pathToReference(hidro_9))
            .into(imageViewHidro_9)

    }
}
