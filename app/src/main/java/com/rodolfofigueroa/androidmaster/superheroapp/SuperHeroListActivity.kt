package com.rodolfofigueroa.androidmaster.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodolfofigueroa.androidmaster.R
import com.rodolfofigueroa.androidmaster.databinding.ActivitySuperHeroListBinding
import com.rodolfofigueroa.androidmaster.superheroapp.DetailsActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.coroutines.CoroutineContext

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter:SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.svHeroes.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        adapter = SuperHeroAdapter(){navigateToDetails(it)}
        binding.rvHeroes.setHasFixedSize(true)
        binding.rvHeroes.layoutManager = GridLayoutManager(this, 2)
        binding.rvHeroes.adapter = adapter
    }

    private fun searchByName(query:String){
        binding.pbHeroes.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val result: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperHero(query)

            if (result.isSuccessful){
                Log.i("retrofit", "Funciona :)")
                val response: SuperHeroDataResponse? = result.body()

                if (response != null){
                    Log.i("retrofit", response.toString())

                    runOnUiThread {
                        adapter.updateList(response.superHeroes)
                        binding.pbHeroes.isVisible = false
                    }
                }

            }else{
                Log.i("retrofit", "No Funciona :(")
            }
        }
    }

    private fun getRetrofit():Retrofit{
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    private fun navigateToDetails(id:String){
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }
}