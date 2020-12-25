package com.project.testappgrowponic.tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.project.testappgrowponic.R
import kotlinx.android.synthetic.main.activity_tutorial4.*
import org.jetbrains.anko.wrapContent

class Tutorial4 : AppCompatActivity() {

    private val sliderValue = SliderAdapter(
        listOf(
            Slider(
                "Pembuatan dan Penggunaan Nutrisi",
                "Alat dan Bahan",
                "",
                "1.Nutrisi AB mix \n\n" +
                        "2.Air\n\n" +
                        "3.Wadah\n\n" +
                        "4.TDS meter*\n\n" +
                        "5.Pengaduk\n\n\n"+
                        "*Keterangan:\n"+
                        "TDS meter adalah alat untuk mengukur kandungan zat yang terlarut dalam air",
                "",
                "",
                "",
                ""
            ),
//            Slider(
//                "Tutorial Pembuatan Nutrisi",
//                "Prosedur Kerja",
//                R.drawable.tut4a_p1,
//                "\n Air dimasukkan ke dalam 2 wadah masing-masing 250 ml. \n",
//                R.drawable.tut4a_p2,
//                "\n Nutrisi A dan B dimasukkan ke wadah yang berbeda. \n"
//            ),
//            Slider(
//                "Tutorial Pembuatan Nutrisi",
//                "Prosedur Kerja",
//                R.drawable.tut4a_p3a,
//                "Masing-masing campuran diaduk hingga larut. \n",
//                R.drawable.tut4a_p3b,
//                ""
//            ),
//            Slider(
//                "Tutorial Pembuatan Nutrisi",
//                "Prosedur Kerja",
//                R.drawable.tut4a_p4a,
//                "\n Air ditambahkan sebanyak 500 ml pada masing-masing wadah, lalu diaduk kembali. \n",
//                R.drawable.tut4a_p4b,
//                ""
//            ),
//            Slider(
//                "Tutorial Pembuatan Nutrisi",
//                "Prosedur Kerja",
//                R.drawable.tut4a_5,
//                "\n Nutrisi yang sudah larut dimasukkan ke dalam botol yang sudah diberi label A dan B. \n",
//                0,
//                "~~"
//            ),
            Slider(
                "Pembuatan dan Penggunaan Nutrisi",
                "Prosedur Kerja",
                "/tutorialfix/nutrisi/1.JPG",
                "\n1. Zat terlarut pada air diukur terlebih dahulu dengan TDS meter. Air yang ideal untuk nutrisi hidroponik memiliki kandungan zat terlarut sebesar 100 ppm* \n\n"+
                        "\n*Keterangan:\n"+
                        "PPM adalah satuan kandungan zat terlarut dalam suatu larutan",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Pembuatan dan Penggunaan Nutrisi",
                "Prosedur Kerja",
                "/tutorialfix/nutrisi/2.JPG",
                "\n2. Nutrisi A dan B dimasukkan dalam wadah yang berisi air, dengan rumus\n" +
                        "1 liter air = 5 ml nutrisi A + 5 ml nutrisi B. \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Pembuatan dan Penggunaan Nutrisi",
                "Prosedur Kerja",
                "/tutorialfix/nutrisi/4.JPG",
                "\n3. Campuran nutrisi dan air diaduk hingga larut \n",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Pembuatan dan Penggunaan Nutrisi",
                "Prosedur Kerja",
                "/tutorialfix/nutrisi/5.JPG",
                "\n4. Larutan nutrisi diukur dengan TDS meter sesuai dengan ppm nutrisi yang dibutuhkan \n"+
                "\n\nPenambahan kepekatan larutan nutrisi akan menaikkan nilai ppm nutrisi\n"+
                "\n\nPenambahan air akan menurunkan nilai ppm nutrisi",
                "",
                "",
                "",
                ""
            ),
            Slider(
                "Pembuatan dan Penggunaan Nutrisi",
                "Prosedur Kerja",
                "/tutorialfix/nutrisi/6.JPG",
                "\n5. Nutrisi siap diberikan pada tanaman \n",
                "",
                "",
                "",
                ""
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial4)
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
