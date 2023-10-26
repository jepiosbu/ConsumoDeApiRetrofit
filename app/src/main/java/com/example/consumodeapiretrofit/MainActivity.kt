


package com.example.consumodeapiretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.consumodeapiretrofit.consumoApi.Api
import com.example.consumodeapiretrofit.consumoApi.modelo
import com.example.consumodeapiretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperardatos()
    }
    fun recuperardatos(){
        Api.service.get().enqueue(object : Callback<List<modelo>> {
            override fun onResponse(call: Call<List<modelo>>, response: Response<List<modelo>>) {
                var data = response.body()
                data!!.forEach {
                    binding.text.append("el id es: ${it.id} y el tipo de mascota es: ${it.name}\n")
                }
            }

            override fun onFailure(call: Call<List<modelo>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }
        })
    }
}

