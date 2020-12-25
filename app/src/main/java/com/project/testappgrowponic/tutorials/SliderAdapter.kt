package com.project.testappgrowponic.tutorials

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.testappgrowponic.R
import com.project.testappgrowponic.glide.GlideApp
import com.project.testappgrowponic.util.StorageUtil
import kotlinx.android.synthetic.main.slide_item_container.view.*

class SliderAdapter (private val slides: List<Slider>) :
        RecyclerView.Adapter<SliderAdapter.SlideViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        return SlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            ),
            parent.context
        )
    }

    override fun getItemCount(): Int {
        return slides.size
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.bind(slides[position])
    }

    inner class SlideViewHolder(view: View, ctx: Context) : RecyclerView.ViewHolder(view) {

        private val teksJudul = view.findViewById<TextView>(R.id.textJudul)
        private val teksDeskripsi = view.findViewById<TextView>(R.id.textDeskripsi)
        private val image1 = view.findViewById<ImageView>(R.id.imageSlide1)
        private val teksPar1 = view.findViewById<TextView>(R.id.teksPar1)
        private val image2 = view.findViewById<ImageView>(R.id.imageSlide2)
        private val teksPar2 = view.findViewById<TextView>(R.id.teksPar2)
        private val image3 = view.findViewById<ImageView>(R.id.imageSlide3)
        private val teksPar3 = view.findViewById<TextView>(R.id.teksPar3)

        private val ctx = ctx

        fun bind(slide: Slider){
            teksJudul.text = slide.judul
            teksDeskripsi.text = slide.deskripsi
//            image1.setImageResource(slide.img1)

            if (slide.img1 != ""){
                GlideApp.with(image1.context)
                    .load(StorageUtil.pathToReference(slide.img1))
                    .into(image1)
            } else {
                image1.setImageResource(0)
            }


            teksPar1.text = slide.par1
//            image2.setImageResource(slide.img2)

            if (slide.img2 != ""){
                GlideApp.with(image2.context)
                    .load(StorageUtil.pathToReference(slide.img2))
                    .into(image2)
            } else {
                image2.setImageResource(0)
            }


            teksPar2.text = slide.par2
//              image3.setImageResource(slide.img3)

            if (slide.img3 != ""){
                GlideApp.with(image3.context)
                    .load(StorageUtil.pathToReference(slide.img3))
                    .into(image3)
            } else {
                image3.setImageResource(0)
            }


            teksPar3.text = slide.par3
        }
    }
}