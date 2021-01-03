package com.project.testappgrowponic.tutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.project.testappgrowponic.MateriActivity
import com.project.testappgrowponic.R
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_tutorial5.*
import kotlinx.android.synthetic.main.activity_tutorial5.tutorialSlider
import kotlinx.android.synthetic.main.slide_item_container.*
import org.jetbrains.anko.wrapContent

class Tutorial5 : AppCompatActivity() {

    private val sliderValue = SliderAdapter(
        listOf(
            Slider(
                "Kegiatan Pengamatan",
                "",
                "/tambahan tutorial/semaian1.png",
                "Semaian yang sudah tumbuh besar siap dipindah tanam\n",
                "/tambahan tutorial/pindah  (2).png",
                "Semaian yang dipindah tanam memiliki kualitas yang baik (tidak menguning dan tidak etiolasi)\n",
                "/tambahan tutorial/nutrisi (2).png",
                "Setiap harinya, tanaman diberi nutrisi dengan kadar tertentu sesuai kebutuhan tanaman"

            ),
            Slider(
                "Kegiatan Pengamatan",
                "Pemberian Nutrisi",
                "/tambahan tutorial/nutrisirev.png",
                "1. Besar kadar nutrisi yang diberikan ke tanaman dapat dilihat di jadwal pemberian nutrisi\n" +
                        "\nPeningkatan kadar nutrisi dilakukan dengan mengukur kadar nutrisi awal terlebih dahulu, sehingga diketahui besar kadar nutrisi yang perlu ditambahkan\n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Kegiatan Pengamatan",
                "Pencatatan Hasil Pengamatan",
                "/tambahan tutorial/catat.PNG",
                "2. Pertumbuhan dan perkembangan tanaman meliputi panjang tanaman dan jumlah daun dicatat dan didokumentasikan setiap harinya",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Kegiatan Pengamatan",
                "Konsultasi Pertumbuhan dan Perkembangan Tanaman",
                "/tambahan tutorial/konsulrev.png",
                "3. Siswa dapat berkonsultasi kepada guru terkait hambatan dalam proses penanaman dan pengamatan",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Kegiatan Pengamatan",
                "Pelaporan Hasil Pengamatan",
                "/tambahan tutorial/laporev.png",
                "4. Data hasil pengamatan beserta dokumentasinya dilaporkan kepada guru melalui fitur ruang diskusi setiap minggunya",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Kegiatan Pengamatan",
                "Pengemasan Sayuran",
                "/tambahan tutorial/pengemasan.PNG",
                "5. Sayuran hidroponik yang berhasil dipanen, selanjutnya dikemas dan dijual",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Kegiatan Pengamatan",
                "Pelaporan Penjualan Sayuran",
                "/tambahan tutorial/jualrev.png",
                "6. Laporan penjualan sayuran meliputi biaya pengeluaran selama penanaman, harga jual sayuran, dan proses pemasaran dilaporkan kepada guru melalui fitur ruang diskusi",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Kegiatan Pengamatan",
                "Penyusunan Laporan Pengamatan",
                "/tambahan tutorial/laporan.PNG",
                "7. Laporan pengamatan membahas tentang pengaruh faktor luar terhadap pertumbuhan dan perkembangan sayuran",
                "",
                "",
                "",
                ""
            )


            )

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial5)
        //slider call
        tutorialSlider.adapter = this.sliderValue

        //core indicator
        setupIndicator()

        //core indicator current page
        setCurrentIndicator(0)

        //indicator current page
        tutorialSlider.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        //tombol next
        button_next.setOnClickListener {
            tutorialSlider.currentItem += 1
        }

        button_back.setOnClickListener {
            tutorialSlider.currentItem -= 1
        }

//      teksKembali.setOnClickListener {
//                Intent(applicationContext, MateriActivity::class.java).also {
//                    startActivity(it)
//                    finish()
//              }
//      }
    }


    private fun setupIndicator() {
        val indicators = arrayOfNulls<ImageView>(sliderValue.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(wrapContent, wrapContent)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.slider_indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.slider_indicator_inactive
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.slider_indicator_inactive
                    )
                )
            }
        }
    }

}
