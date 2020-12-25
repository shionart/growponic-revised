package com.project.testappgrowponic.model


data class User(val name: String,
                val profilePicturePath: String?,
                val registrationTokens: MutableList<String>){
    constructor(): this("", null, mutableListOf())
}