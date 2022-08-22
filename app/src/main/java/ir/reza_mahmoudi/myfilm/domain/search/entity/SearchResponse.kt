package ir.reza_mahmoudi.myfilm.domain.search.entity

import com.google.gson.annotations.SerializedName

data class SearchResponse (
    @SerializedName("data")
    val movieList: List<MovieItem>,
)