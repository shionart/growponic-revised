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
import kotlinx.android.synthetic.main.activity_tutorial1.*
import org.jetbrains.anko.wrapContent

class Tutorial1 : AppCompatActivity() {

    //TODO : Tombol menu dibawah slider kayanya dihapus ajaa
    //TODO : Uwis

    //isi slider
        //tambah slider di sini
    private val sliderValue = SliderAdapter(
        listOf(
            Slider(
                "Menyemai Biji",
                "Alat dan Bahan",
                "",
                "1. Rockwool\n\n" +
                        "2. Pisau \n\n" +
                        "3. Penggaris \n\n" +
                        "4. Tusuk gigi\n\n" +
                        "5. Nampan \n\n" +
                        "6. Biji tanaman\n\n" +
                        "7. Air ",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/1.JPG",
                "\n1. Rockwool dipotong setebal ± 2cm menggunakan pisau \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/2.JPG",
                "\n2. Rockwool dibagi menjadi 10 bagian, bagian pendek menjadi 2 bagian dan bagian panjang menjadi 5 bagian \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/3.JPG",
                "\n3. Setiap kotak rockwool dilubangi sedalam ± 0,5cm dengan tusuk gigi \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/4.JPG",
                "\n4. Lubang untuk biji sawi dibuat sebanyak 1 lubang pada setiap kotak \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/5.JPG",
                "\n5. Lubang untuk biji kangkung dibuat sebanyak 5-6 lubang pada setiap kotak \n"+
                "\nLubang untuk biji bayam dibuat sebanyak 2-4 lubang pada setiap kotak",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/7.JPG",
                "\n6. Biji tanaman dimasukkan ke dalam lubang pada rockwool \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/8.JPG",
                "\n7. Rockwool diletakkan di nampan, lalu dibasahi dengan air \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Menyemai Biji",
                "Prosedur Kerja",
                "/tutorialfix/menyemai/9.JPG",
                "\n8. Sebelum biji bertunas, rockwool diletakkan di tempat yang tidak terkena sinar matahari.\n"+
                        "\nSetelah muncul tunas putih kehijauan, rockwool diletakkan di tempat yang terkena sinar matahari tetapi tetap ternaungi\n",
                "",
                "",
                "",
                ""
        )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial1)

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
