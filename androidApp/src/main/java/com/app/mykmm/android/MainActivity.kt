package com.app.mykmm.android

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.app.mykmm.Greeting
import com.app.mykmm.android.connection.API
import com.app.mykmm.android.databinding.ActivityMainBinding
import com.app.mykmm.android.model.login
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Response

//ViwBinding. activity_main ==> ActivityMainBinding
private var binding: ActivityMainBinding? = null

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val jsonObject = JSONObject()
        jsonObject.put("email", "dhafinjulda@gmail.com")
        jsonObject.put("password", "password")

        // Convert JSONObject to String
        val jsonObjectString = jsonObject.toString()

        // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

        binding!!.btnOke.setOnClickListener {
            val compositeDisposable = CompositeDisposable()
            compositeDisposable.add(

                API.buildService().getLogin(requestBody)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        Log.i(TAG, "onCreate: Progress")
                    }
                    .subscribeOn(Schedulers.io())
                    .doOnComplete {
                        binding!!.btnOke.setText("Complite")
                    }
                    .subscribe(
                        { login ->
                            onResponse(login)
                        },
                        { t ->
                            onFailure(t)
                        }
                    )
            )

        }
    }

    private fun onResponse(response: login) {
        binding?.textView?.setText(response.user.name)
    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
    }
}
