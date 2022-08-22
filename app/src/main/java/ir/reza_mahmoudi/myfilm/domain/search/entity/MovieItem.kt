package ir.reza_mahmoudi.myfilm.domain.search.entity

import com.google.gson.annotations.SerializedName

data class MovieItem (
    @SerializedName("movie_id")
    val id: Int,
    @SerializedName("movie_title")
    val title: String,
    @SerializedName("descr")
    val description: String,
    @SerializedName("pic")
    val pictures: Pictures,
    @SerializedName("rate_avrage")
    val rate: Double,
    @SerializedName("publish_date")
    val publishDate: String
)