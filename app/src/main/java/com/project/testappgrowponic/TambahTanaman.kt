package com.project.testappgrowponic

import android.app.ProgressDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.project.testappgrowponic.model.JenisTanaman
import com.project.testappgrowponic.model.Tanaman
import com.project.testappgrowponic.util.FirestoreUtil
import kotlinx.android.synthetic.main.activity_tambah_tanaman.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class TambahTanaman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_tanaman)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        FirestoreUtil.getDaftarJenisTanaman { listJenisTanaman ->
            progressDialog.dismiss()

            var jenis_tanaman: JenisTanaman

            val adapter = ArrayAdapter<JenisTanaman>(this, R.layout.spinner_theme, listJenisTanaman)
            adapter.setDropDownViewResource(R.layout.spinner_theme);
            spinner_jenis_tanaman.adapter = adapter

            spinner_jenis_tanaman.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    jenis_tanaman = listJenisTanaman[p2]
                    simpanTanaman(jenis_tanaman)
                }
            }
        }
    }

    private fun simpanTanaman(jenis: JenisTanaman){
        button_simpan_tanaman.setOnClickListener {

            val idJenisTanaman = jenis.documentId
            val nama = editText_nama_tanaman.text.trim().toString()
            val tanggalTanam = getDaysLater(0)

            var perawatan = mutableListOf<String>()
            for((k, v) in jenis.perawatan.toSortedMap()){
                perawatan.add(getDaysLater(v[0].toInt()))
            }

            val panen = getDaysLater(jenis.panen)

            val tanaman = Tanaman("", idJenisTanaman, nama, tanggalTanam, perawatan, panen)

            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Menyimpan data...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            FirestoreUtil.simpanTanaman(tanaman){status ->
                progressDialog.dismiss()
                if(status[0] == "True"){
                    Toast.makeText(this, "Data tanaman berhasil disimpan", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this, "Terjadi kesalahan saat menyimpan data", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getDaysLater(daysLater: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, +daysLater)
        val format = SimpleDateFormat("dd MMMM yyyy")
        val tanggal = format.format(calendar.time)
        return tanggal
    }
}
