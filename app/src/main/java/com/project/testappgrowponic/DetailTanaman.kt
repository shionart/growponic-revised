package com.project.testappgrowponic

import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.storage.FirebaseStorage
import com.project.testappgrowponic.model.JenisTanaman
import com.project.testappgrowponic.model.Tanaman
import com.project.testappgrowponic.recyclerview.item.DetailTanamanItem
import com.project.testappgrowponic.util.FirestoreUtil
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_detail_tanaman.*
import kotlinx.android.synthetic.main.item_tanaman.*
import kotlinx.android.synthetic.main.item_tanaman.textView_nama_tanaman

class DetailTanaman : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tanaman)

        val intent = intent
        val idTanaman = intent.getStringExtra("id")!!.toString()

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        FirestoreUtil.getTanaman(idTanaman){ tanaman ->
            FirestoreUtil.getJenisTanaman(tanaman.idJenisTanaman){ jenisTanaman ->
                textView_jenis_tanaman.text = "Jenis : "+jenisTanaman.nama
                textView_nama_tanaman.text = tanaman.nama

                val adapter = GroupAdapter<ViewHolder>()
                adapter.add(DetailTanamanItem(arrayListOf(tanaman.tanggalTanam, "Mulai ditanam")))

                jenisTanaman.perawatan.toSortedMap().forEach{
                    var perawatan = mutableListOf<String>()

                    perawatan.add(tanaman.perawatan.get(it.key.toInt()))
                    perawatan.add(it.value.get(1))

                    if (it.value.size >=3){
                        perawatan.add(it.value.get(2))
                    }

                    adapter.add(DetailTanamanItem(perawatan))
                }

                adapter.add(DetailTanamanItem(arrayListOf(tanaman.tanggalPanen, "Siap panen")))

                recycler_view_deskripsi.apply {
                    layoutManager = LinearLayoutManager(this.context)
                }
                recycler_view_deskripsi.adapter = adapter

                progressDialog.dismiss()
            }
        }

        button_hapus.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("Data tanaman akan dihapus.")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Hapus", DialogInterface.OnClickListener { dialog, id ->
                    val progressDialog = ProgressDialog(this)
                    progressDialog.setMessage("Menghapus data...")
                    progressDialog.setCancelable(false)
                    progressDialog.show()

                    FirestoreUtil.hapusTanaman(idTanaman){ status ->
                        progressDialog.dismiss()
                        if(status[0] == "True"){
                            Toast.makeText(this, "Data tanaman berhasil dihapus", Toast.LENGTH_LONG).show()
                            finish()
                        } else {
                            Toast.makeText(this, "Terjadi kesalahan saat menghapus data", Toast.LENGTH_LONG).show()
                        }
                    }
                })
                // negative button text and action
                .setNegativeButton("Batal", DialogInterface.OnClickListener {dialog, id ->
                    dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("Apakah anda yakin ?")
            alert.show()
        }
    }
}
