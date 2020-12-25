package com.project.testappgrowponic.model

import com.google.firebase.firestore.DocumentId

data class Tanaman (
    @DocumentId val documentId: String,
    val idJenisTanaman : String,
    val nama : String,
    val tanggalTanam : String,
    val perawatan : List<String>,
    val tanggalPanen : String
    ){
    constructor(): this("","","", "", emptyList<String>(), "")
}