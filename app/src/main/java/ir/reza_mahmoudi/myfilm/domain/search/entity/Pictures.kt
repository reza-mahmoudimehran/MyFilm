package ir.reza_mahmoudi.myfilm.domain.search.entity

import com.google.gson.annotations.SerializedName

data class Pictures(
    @SerializedName("movie_img_s")
    val small: String,
    @SerializedName("movie_img_m")
    val medium: String,
    @SerializedName("movie_img_b")
    val big: String
)
