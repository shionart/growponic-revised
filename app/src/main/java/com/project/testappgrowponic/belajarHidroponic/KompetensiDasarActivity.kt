package com.project.testappgrowponic.belajarHidroponic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.testappgrowponic.R
import com.project.testappgrowponic.util.StorageUtil
import kotlinx.android.synthetic.main.activity_kompetensi_dasar.*


class KompetensiDasarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kompetensi_dasar)

        val tabel_ki = "/materi/kompetensi/KI2.png"
        val tabel_kd = "/materi/kompetensi/KD2.png"
        val tabel_ipk = "/materi/kompetensi/IPK2.png"
        val tujpel = "/materi/kompetensi/tujpel.png"
        val tujprak = "/materi/kompetensi/tujprak2.png"


        //load tabel ki
        Glide.with(this)
            .load(StorageUtil.pathToReference(tabel_ki))
            .into(imageViewTabel_ki)

        //load tabel kd
        Glide.with(this)
            .load(StorageUtil.pathToReference(tabel_kd))
            .into(imageViewTabel_kd)

        //load tabel ipk
        Glide.with(this)
            .load(StorageUtil.pathToReference(tabel_ipk))
            .into(imageViewTabel_ipk)

        //load tujpel
        Glide.with(this)
            .load(StorageUtil.pathToReference(tujpel))
            .into(imageViewTujpel)

        //load tujprak
        Glide.with(this)
            .load(StorageUtil.pathToReference(tujprak))
            .into(imageViewTujprak)



    }
}