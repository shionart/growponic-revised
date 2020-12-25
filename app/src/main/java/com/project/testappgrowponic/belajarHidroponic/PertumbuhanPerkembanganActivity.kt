package com.project.testappgrowponic.belajarHidroponic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.testappgrowponic.R
import com.project.testappgrowponic.util.StorageUtil
import kotlinx.android.synthetic.main.activity_pertumbuhan_perkembangan.*

class PertumbuhanPerkembanganActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertumbuhan_perkembangan)

        val pdpt_14 = "/materi/pertumbuhan-dan-perkembangan-tanaman/PPT.png"
        val pdpt_15 = "/materi/pertumbuhan-dan-perkembangan-tanaman/Perkecambahan.png"
        val pdpt_16 = "/materi/pertumbuhan-dan-perkembangan-tanaman/pprimersekunder.png"
        val pdpt_17 = "/materi/pertumbuhan-dan-perkembangan-tanaman/ppmeristem.jpg"
        val pdpt_18 = "/materi/pertumbuhan-dan-perkembangan-tanaman/layusegar.png"
        val pdpt_19 = "/materi/pertumbuhan-dan-perkembangan-tanaman/faktortumbuhan (2).png"
        val pdpt_20 = "/materi/pertumbuhan-dan-perkembangan-tanaman/tips menanam.png"




        //Load Gambar 14
        Glide.with(this)
            .load(StorageUtil.pathToReference(pdpt_14))
            .into(imageViewPdPT_14)

        //Load Gambar 15
        Glide.with(this)
            .load(StorageUtil.pathToReference(pdpt_15))
            .into(imageViewPdPT_15)

        //Load Gambar 16
        Glide.with(this)
            .load(StorageUtil.pathToReference(pdpt_16))
            .into(imageViewPdPT_16)

        //Load Gambar 17
        Glide.with(this)
            .load(StorageUtil.pathToReference(pdpt_17))
            .into(imageViewPdPT_17)

        //Load Gambar 18
        Glide.with(this)
            .load(StorageUtil.pathToReference(pdpt_18))
            .into(imageViewPdPT_18)

        //Load Gambar 19
        Glide.with(this)
                .load(StorageUtil.pathToReference(pdpt_19))
                .into(imageViewPdPT_19)

        //Load Gambar 20
        Glide.with(this)
                .load(StorageUtil.pathToReference(pdpt_20))
                .into(imageViewPdPT_20)


    }
}
