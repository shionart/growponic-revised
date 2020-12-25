package com.project.testappgrowponic.model

data class ChatChannel(val userIds: MutableList<String>) {
    constructor() : this(mutableListOf())
}