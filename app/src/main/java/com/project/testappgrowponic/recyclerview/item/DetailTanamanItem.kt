package com.project.testappgrowponic.recyclerview.item

import android.view.View
import com.project.testappgrowponic.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.item_detail_perawatan.view.*

class DetailTanamanItem(val detail: List<String>) : Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.item_detail_perawatan
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val itemView = viewHolder.itemView
        itemView.textView_tanggal.text = detail[0]
        itemView.textView_deskripsi.text = detail[1]

        if(detail.size >= 3){
            itemView.textView_deskripsi_ext.visibility = View.VISIBLE
            itemView.textView_deskripsi_ext.text = detail[2]
        }
    }
}