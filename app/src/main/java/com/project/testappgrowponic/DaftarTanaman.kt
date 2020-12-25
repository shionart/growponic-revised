package com.project.testappgrowponic

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.testappgrowponic.model.Tanaman
import com.project.testappgrowponic.recyclerview.item.TanamanItem
import com.project.testappgrowponic.util.FirestoreUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_daftar_tanaman.*

class DaftarTanaman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_tanaman)

        button_tambah_tanaman.setOnClickListener {
            val intent = Intent(this, TambahTanaman::class.java)
            startActivity(intent)
        }

        loadTanaman()
    }

    override fun onRestart() {
        super.onRestart()

        loadTanaman()
    }

    private fun loadTanaman() {
        textView_empty.visibility = View.GONE
        recycler_view_tanaman.visibility = View.GONE


        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        FirestoreUtil.getDaftarTanaman { listTanaman ->
            progressDialog.dismiss()

            if (listTanaman.size <= 0) {
                textView_empty.visibility = View.VISIBLE

            } else {
                recycler_view_tanaman.visibility = View.VISIBLE
                val adapter = GroupAdapter<ViewHolder>()

                listTanaman.forEach {
                    adapter.add(TanamanItem(it))
                }

                recycler_view_tanaman.apply {
                    layoutManager = LinearLayoutManager(this.context)
                }

                adapter.setOnItemClickListener { item, view ->
                    val tanamanItem = item as TanamanItem
//                    Toast.makeText(this, "Perawatan : "+tanamanItem.tanaman.perawatan.size, Toast.LENGTH_SHORT ).show()

                    val intent = Intent(this, DetailTanaman::class.java)
                    intent.putExtra("id", tanamanItem.tanaman.documentId)
                    startActivity(intent)
                }
                recycler_view_tanaman.adapter = adapter
            }
        }
    }
}
