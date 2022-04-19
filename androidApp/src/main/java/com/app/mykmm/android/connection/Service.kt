package com.app.mykmm.android.connection

import com.app.mykmm.android.model.login
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

    @POST("api/v1/users/login_email")
    fun getLogin(@Body requestBody: RequestBody): Observable<login>

}