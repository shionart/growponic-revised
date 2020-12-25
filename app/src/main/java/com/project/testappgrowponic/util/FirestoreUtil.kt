@file:Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")

package com.project.testappgrowponic.util

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import com.project.testappgrowponic.model.*
import com.project.testappgrowponic.recyclerview.item.ImageMessageItem
import com.project.testappgrowponic.recyclerview.item.PersonItem
import com.project.testappgrowponic.recyclerview.item.TextMessageItem
import com.xwray.groupie.kotlinandroidextensions.Item
import java.lang.NullPointerException

object FirestoreUtil{
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    private val currentUserDocRef: DocumentReference
    get() = firestoreInstance.document("users/${FirebaseAuth.getInstance().currentUser?.uid
        ?: throw  NullPointerException("UID is null.")}")


    //create chat channel colection in fire store yang menyimpan koleksi data chat
    //beserta isi chatnya
    private val chatChannelIsCollectionRef = firestoreInstance.collection("chatChannels")



    fun initCurrentUserIfFirstTime(onComplete: () -> Unit){
        currentUserDocRef.get().addOnSuccessListener {documentSnapshot ->
            if(!documentSnapshot.exists()){
                val newUser = User(FirebaseAuth.getInstance().currentUser?.displayName ?: "",
                    null, mutableListOf())
                currentUserDocRef.set(newUser).addOnSuccessListener {
                    onComplete()
                }
            }
            else{
                onComplete()
            }
        }
    }

    fun updateCurrentUser(name: String ="", profilePicturePath: String? = null){
        val userFieldMap = mutableMapOf<String,Any>()
        if (name.isNotBlank()) userFieldMap["name"] = name
        if (profilePicturePath != null)
            userFieldMap["profilePicturePath"] = profilePicturePath
        currentUserDocRef.update(userFieldMap)
    }

    fun getCurrentUser(onComplete: (User) -> Unit){
        currentUserDocRef.get()
            .addOnSuccessListener {
                onComplete(it.toObject(User::class.java)!!)
            }
    }

    fun addUsersListener(context: Context, onListen: (List<Item>) -> Unit): ListenerRegistration {
        return firestoreInstance.collection("users")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null) {
                    Log.e("FIRESTORE", "Users listener error.", firebaseFirestoreException)
                    return@addSnapshotListener
                }

                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    if (it.id != FirebaseAuth.getInstance().currentUser?.uid)
                        items.add(PersonItem(it.toObject(User::class.java)!!, it.id, context))
                }
                onListen(items)
            }
    }

    fun removeListener(registration: ListenerRegistration) = registration.remove()

    fun getOrCreateChatChannel(otherUserId: String, onComplete: (channelId: String) -> Unit){
        currentUserDocRef.collection("engagedChatChannels")
            .document(otherUserId).get().addOnSuccessListener {
                if(it.exists()){
                    onComplete(it["channelId"] as @kotlin.ParameterName(name = "channelId") String)
                    return@addOnSuccessListener
                }

                val currentUserId = FirebaseAuth.getInstance().currentUser!!.uid

                val newChannel = chatChannelIsCollectionRef.document()
                newChannel.set(ChatChannel(mutableListOf(currentUserId, otherUserId)))

                currentUserDocRef
                    .collection("engagedChatChannels")
                    .document(otherUserId)
                    .set(mapOf("channelId" to newChannel.id))

                firestoreInstance.collection("users").document(otherUserId)
                    .collection("engagedChatChannels")
                    .document(currentUserId)
                    .set(mapOf("channelId" to newChannel.id))

                onComplete(newChannel.id)
            }
    }

    fun addChatMessagesListener(channelId: String, context: Context,
                                onListen: (List<Item>) -> Unit): ListenerRegistration{
        return chatChannelIsCollectionRef.document(channelId).collection("messages")
            .orderBy("time")
            .addSnapshotListener{ querySnapshot, firebaseFirestoreException ->
                if (firebaseFirestoreException != null){
                    Log.e("FIRESTORE", "ChatMessagesListener Error.",firebaseFirestoreException)
                    return@addSnapshotListener
                }

                val items = mutableListOf<Item>()
                querySnapshot!!.documents.forEach {
                    if (it["type"] == MessageType.TEXT)
                        items.add(TextMessageItem(it.toObject(TextMessage::class.java)!!, context))
                    else
                        items.add(ImageMessageItem(it.toObject(ImageMessage::class.java)!!, context))
                    return@forEach
                }
                onListen(items)
            }
    }

    fun sendMessage(message: Message, channelId: String) {
        chatChannelIsCollectionRef.document(channelId)
            .collection("messages")
            .add(message)
    }

    //region FCM
    fun getFCMRegistrationTokens(onComplete: (tokens: MutableList<String>) -> Unit) {
        currentUserDocRef.get().addOnSuccessListener {
            val user = it.toObject(User::class.java)!!
            onComplete(user.registrationTokens)
        }
    }

    fun setFCMRegistrationTokens(registrationTokens: MutableList<String>) {
        currentUserDocRef.update(mapOf("registrationTokens" to registrationTokens))
    }
    //endregion FCM

    fun getDaftarJenisTanaman(onComplete: (MutableList<JenisTanaman>) -> Unit){
        firestoreInstance.collection("jenisTanaman").get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    var listJenisTanaman = emptyList<JenisTanaman>().toMutableList()
                    listJenisTanaman = task.result!!.toObjects(JenisTanaman::class.java)
                    onComplete(listJenisTanaman)
                }
            }
            .addOnFailureListener {
                Log.d("ERROR", it.message.toString())
            }
    }

    fun getJenisTanaman(idJenisTanaman: String, onComplete: (JenisTanaman) -> Unit){
        firestoreInstance.collection("jenisTanaman")
            .document(idJenisTanaman)
            .get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    val jenisTanaman = task.result!!.toObject(JenisTanaman::class.java)
                    if (jenisTanaman != null) {
                        onComplete(jenisTanaman)
                    }
                }
            }
            .addOnFailureListener {
                Log.d("ERROR", it.message.toString())
            }
    }

    fun simpanTanaman(tanaman: Tanaman, onComplete: (status: List<String>) -> Unit){
        val status = mutableListOf<String>()
        currentUserDocRef
            .collection("tanaman")
            .add(tanaman)
            .addOnSuccessListener {
                status.add(0, "True")
                status.add(1, it.id)
                onComplete(status)
            }
            .addOnFailureListener {
                status.add(0, "False")
                status.add(1, it.message.toString())
                onComplete(status)
            }
    }

    fun getDaftarTanaman(onComplete: (MutableList<Tanaman>) -> Unit){
        currentUserDocRef.collection("tanaman").orderBy("tanggalTanam", Query.Direction.DESCENDING).get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    var listTanaman = emptyList<Tanaman>().toMutableList()
                    listTanaman = task.result!!.toObjects(Tanaman::class.java)
                    onComplete(listTanaman)
                }
            }
            .addOnFailureListener {
                Log.d("ERROR", it.message.toString())
            }
    }

    fun getTanaman(id: String, onComplete: (Tanaman) -> Unit){
        currentUserDocRef.collection("tanaman").document(id).get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    val tanaman = task.result!!.toObject(Tanaman::class.java)
                    if (tanaman != null) {
                        onComplete(tanaman)
                    }
                }
            }
            .addOnFailureListener {
                Log.d("ERROR", it.message.toString())
            }
    }

    fun hapusTanaman(id: String, onComplete: (status: List<String>) -> Unit){
        val status = mutableListOf<String>()
        currentUserDocRef.collection("tanaman").document(id)
            .delete()
            .addOnSuccessListener {
                status.add(0, "True")
                onComplete(status)
            }
            .addOnFailureListener {
                status.add(0, "False")
                status.add(1, it.message.toString())
                onComplete(status)
            }
    }


}