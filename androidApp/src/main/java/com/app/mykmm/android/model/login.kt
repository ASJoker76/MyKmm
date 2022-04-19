package com.app.mykmm.android.model

data class login(
    val refresh_token: String,
    val token: String,
    val user: User
)