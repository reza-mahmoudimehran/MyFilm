package ir.reza_mahmoudi.myfilm.domain.search.entity

import com.google.gson.annotations.SerializedName

data class MovieItem (
    @SerializedName("movie_id")
    val id: Double,
    @SerializedName("movie_title")
    val title: Double,
    @SerializedName("descr")
    val description: Double,
    @SerializedName("rate_avrage")
    val rate: Double,
    @SerializedName("publish_date")
    val publishDate: Double
)