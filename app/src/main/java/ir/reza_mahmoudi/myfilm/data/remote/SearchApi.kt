package ir.reza_mahmoudi.myfilm.data.remote

import ir.reza_mahmoudi.myfilm.domain.entity.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchApi {
    @GET("api/en/v1/movie/movie/list/tagid/1000300/text/{Query}/sug/on")
    suspend fun search(@Path("Query") text: String) : Response<SearchResponse>
}