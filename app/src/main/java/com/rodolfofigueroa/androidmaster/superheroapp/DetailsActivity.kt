package com.rodolfofigueroa.androidmaster.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import com.rodolfofigueroa.androidmaster.R
import com.rodolfofigueroa.androidmaster.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailsActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    lateinit var binding: ActivityDetailsBinding
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id:String = intent.getStringExtra(EXTRA_ID).orEmpty()
        retrofit = getRetrofitInstance()
        getSuperHeroData(id)
    }

    private fun getSuperHeroData(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result : Response<SuperHeroDetailResponse> = retrofit.create(ApiService::class.java).getSuperHeroId(id)

            runOnUiThread {
                if (result.body() != null){
                    createUI(result.body()!!)

                }else{
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un Error", Toast.LENGTH_SHORT).show()
    }

    private fun createUI(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivHeroDetails)
        binding.tvHeroDetailsName.text = superhero.name
        binding.tvHeroDetailsRealName.text = superhero.biography.fullName
        binding.tvHeroDetailsPlaceBirth.text = superhero.biography.placeBirth
        binding.tvHeroDetailsPublisher.text = superhero.biography.publisher.orEmpty()
        prepareStats(superhero)
    }

    private fun prepareStats(superhero: SuperHeroDetailResponse) {
        updateStatHeight(binding.viewCombat, superhero.powerstats.combat)
        updateStatHeight(binding.viewDurability, superhero.powerstats.durability)
        updateStatHeight(binding.viewIntelligence, superhero.powerstats.intelligence)
        updateStatHeight(binding.viewPower, superhero.powerstats.power)
        updateStatHeight(binding.viewSpeed, superhero.powerstats.speed)
        updateStatHeight(binding.viewStrength, superhero.powerstats.strength)
    }

    private fun updateStatHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofitInstance():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}