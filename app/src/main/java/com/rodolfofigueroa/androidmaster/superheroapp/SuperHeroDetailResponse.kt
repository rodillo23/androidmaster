package com.rodolfofigueroa.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailResponse(
    @SerializedName("name") val name:String,
    @SerializedName("powerstats") val powerstats:PowerStatsResponse,
    @SerializedName("biography") val biography:BiographyResponse,
    @SerializedName("image") val image:ImageDetailsResponse
)

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence:String,
    @SerializedName("strength") val strength:String,
    @SerializedName("speed") val speed:String,
    @SerializedName("durability") val durability:String,
    @SerializedName("power") val power:String,
    @SerializedName("combat") val combat:String,

)

data class BiographyResponse(
    @SerializedName("full-name") val fullName:String,
    @SerializedName("place-of-birth") val placeBirth:String,
    @SerializedName("publisher") val publisher:String
)

data class ImageDetailsResponse(
    @SerializedName("url") val url:String
)