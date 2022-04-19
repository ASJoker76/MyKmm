package com.app.mykmm.android.model

data class User(
    val birthdate: String,
    val created: String,
    val customer_id: Int,
    val email: String,
    val gender: String,
    val id: String,
    val is_email_verified: Boolean,
    val ktp: Any,
    val loan_level: String,
    val login_provider: String,
    val name: String,
    val noref_dplus: String,
    val outlet_addresses: List<OutletAddresse>,
    val outlets: Outlets,
    val phone_number: String,
    val photo_url: String,
    val reset_password_expired_at: Any,
    val reset_password_token: Any,
    val role_status: String,
    val updated: String,
    val user_address: Any
)