package com.app.mykmm.android.model

data class Outlets(
    val created: String,
    val id: String,
    val mobile_phone: String,
    val name: String,
    val no_sia: String,
    val no_sia_expired_date: String,
    val no_sipa: String,
    val no_sipa_expired_date: String,
    val npwp: String,
    val outlet_docs: List<OutletDoc>,
    val telephone: String,
    val type: String,
    val updated: String
)