package com.project.testappgrowponic.tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.project.testappgrowponic.R
import kotlinx.android.synthetic.main.activity_tutorial3.*
import org.jetbrains.anko.wrapContent

class Tutorial3 : AppCompatActivity() {

    private val sliderValue = SliderAdapter(
        listOf(
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Alat dan Bahan",
                "",
                "1.Boks anggur bekas\n\n" +
                        "2.Plastik hitam atau UV\n\n" +
                        "3.Lem\n\n" +
                        "4.Gelas air mineral bekas\n\n" +
                        "5.Penggaris\n\n" +
                        "6.Cutter\n\n" +
                        "7.Lilin\n\n" +
                        "8.Pelubang gabus sintetis (boks anggur) ",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/1.JPG",
                "\n1. Bagian tutup boks diukur dengan jarak antar titiknya ± 10-15cm, disesuaikan dengan ukuran boks \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/3.JPG",
                "\n2. Ujung pelubang dipanaskan untuk melubangi tutup boks \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/4.JPG",
                "\n3. Bagian tutup boks dilubangi sesuai dengan jarak yang sudah diukur \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/6.JPG",
                "\n4. Bagian dalam boks dilapisi plastik hitam \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/7.JPG",
                "\n5. Nutrisi dituangkan ke dalam boks setinggi ± 3/4 dari tinggi boks, atau hingga akar tanaman terendam nutrisi \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/8.JPG",
                "\n6. Boks kembali ditutup \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/9 edit.jpeg",
                "\n7. Sisi samping bawah gelas mineral dilubangi sebanyak 5-6 lubang sebagai tempat keluar akar. Masing-masing lubang berukuran ± 1x4cm  \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Merancang Instalasi Deep Water Culture",
                "Prosedur Kerja",
                "/tutorialfix/deep water/11.JPG",
                "\n8. Gelas mineral diletakkan ke dalam lubang pada boks sebagai netpot \n",
                "",
                "",
                "",
                ""
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial3)
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
