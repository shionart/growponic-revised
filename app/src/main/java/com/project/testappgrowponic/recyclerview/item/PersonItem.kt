package com.project.testappgrowponic.recyclerview.item

import android.content.Context
import com.project.testappgrowponic.R
import com.project.testappgrowponic.glide.GlideApp
import com.project.testappgrowponic.model.User
import com.project.testappgrowponic.util.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_person.*

class PersonItem(
    val person: User,
    val userId: String,
    private val context: Context)
    : Item(){

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView_name.text = person.name
        if (person.profilePicturePath != null)
            GlideApp.with(context)
                .load(StorageUtil.pathToReference(person.profilePicturePath))
                .placeholder(R.drawable.ic_account_circle_white)
                .into(viewHolder.imageView_profile_picture)
    }

    override fun getLayout() = R.layout.item_person
}