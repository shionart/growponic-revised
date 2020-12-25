package com.project.testappgrowponic.tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.project.testappgrowponic.R
import kotlinx.android.synthetic.main.activity_tutorial2.*
import org.jetbrains.anko.wrapContent

class Tutorial2 : AppCompatActivity() {

    private val sliderValue = SliderAdapter(
        listOf(
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Botol Mineral \n" + "Alat dan Bahan",
                "",
                "1.Botol mineral bekas\n\n" +
                "2.Kain flanel\n\n" +
                        "3.Cutter/pisau \n\n" +
                        "4.Penggaris",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Botol Mineral \n" + "Prosedur Kerja",
                "/tutorialfix/wick botol/1.JPG",
                "\n1. Bagian atas botol dipotong, ± 10cm dari ujung botol. \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Botol Mineral \n" + "Prosedur Kerja",
                "/tutorialfix/wick botol/2.JPG",
                "\n2. Bagian atas botol yang sudah dipotong, ujungnya dilubangi sebesar ± 2cm untuk memasukkan kain flanel. \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Botol Mineral \n" + "Prosedur Kerja",
                "/tutorialfix/wick botol/3.JPG",
                "3. Kain flanel dimasukkan ke bagian botol yang sudah dilubangi tersebut. \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Botol Mineral \n" + "Prosedur Kerja",
                "/tutorialfix/wick botol/5.JPG",
                "\n4. Nutrisi dituangkan ke dalam bagian bawah botol, ± 2/3 dari tinggi botol\n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Botol Mineral \n" + "Prosedur Kerja",
                "/tutorialfix/wick botol/7.JPG",
                "\n5. Bagian atas dan bawah botol dirangkai jadi satu. Bagian atas botol digunakan untuk meletakkan semaian  \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Alat dan Bahan",
                "",
                "1.Boks anggur bekas\n\n" +
                        "2.Plastik hitam atau UV\n\n" +
                        "3.Lem\n\n" +
                        "4.Kain flanel\n\n" +
                        "5.Gelas air mineral bekas\n\n" +
                        "6.Penggaris\n\n" +
                        "7.Lilin\n\n" +
                        "8.Pelubang gabus sintetis (boks anggur)",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /1.JPG",
                "\n1. Bagian tutup boks ditandai dengan jarak antar titiknya ± 10-15cm, disesuaikan dengan ukuran boks \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /3.JPG",
                "\n2. Ujung pelubang dipanaskan untuk melubangi tutup boks \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /4.JPG",
                "\n3. Bagian tutup boks dilubangi sesuai dengan jarak yang sudah diukur\n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /6.JPG",
                "\n4. Bagian dalam boks dilapisi plastik hitam \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /7.JPG",
                "\n5. Nutrisi dituangkan ke dalam boks setinggi ± 1/2 dari tinggi boks \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /8.JPG",
                "\n6. Boks kembali ditutup \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /9 edit.jpeg",
                "\n7. Sisi samping bawah gelas mineral dilubangi sebanyak 5-6 lubang sebagai tempat keluar akar. Masing-masing lubang berukuran ± 1x4cm \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /10 edit.jpeg",
                "\n8. Kain flanel dimasukkan ke dalam lubang pada gelas mineral bekas \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Wick System",
                "Menggunakan Boks Anggur \n" + "Prosedur Kerja",
                "/tutorialfix/wick box /11.JPG",
                "\n9. Gelas mineral diletakkan ke dalam lubang pada boks sebagai netpot \n",
                "",
                "",
                "",
                ""
            )

        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial2)

        //slider call
        tutorialSlider.adapter = this.sliderValue

        //core indicator
        setupIndicator()

        //core indicator current page
        setCurrentIndicator(0)

        //indikator current page
        tutorialSlider.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){

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

//        teksKembali.setOnClickListener {
//            Intent(applicationContext, MateriActivity::class.java).also{
//                startActivity(it)
//                finish()
//            }
//        }
    }

    private fun setupIndicator(){
        val indicators = arrayOfNulls<ImageView>(sliderValue.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(wrapContent, wrapContent)
        layoutParams.setMargins(8,0,8,0)
        for(i in indicators.indices){
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

    private fun setCurrentIndicator(index: Int){
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorContainer[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.slider_indicator_active
                    )
                )
            } else{
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
