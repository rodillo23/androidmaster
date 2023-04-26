package com.rodolfofigueroa.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/6002077593173045/search/{name}")
    suspend fun getSuperHero(@Path("name") superHeroName:String) : Response<SuperHeroDataResponse>

    @GET("api/6002077593173045/{id}")
    suspend fun getSuperHeroId(@Path("id") superHeroId:String) : Response<SuperHeroDetailResponse>
}