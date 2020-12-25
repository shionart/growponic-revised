package com.project.testappgrowponic.recyclerview.item

import com.project.testappgrowponic.R
import com.project.testappgrowponic.model.Tanaman
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.item_tanaman.view.*

class TanamanItem(val tanaman: Tanaman) : Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.item_tanaman
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val itemView = viewHolder.itemView
        itemView.textView_nama_tanaman.text = tanaman.nama
        itemView.textView_tanggal_tanam.text = "Tanggal tanam : "+tanaman.tanggalTanam
    }

}