package com.project.testappgrowponic.model

import com.google.firebase.firestore.DocumentId

data class JenisTanaman(
    @DocumentId val documentId: String,
    val nama : String,
    val panen : Int,
    val perawatan: Map<String, List<String>>
) {
    constructor(): this("", "", 0, emptyMap())

    override fun toString(): String {
        return nama
    }


}