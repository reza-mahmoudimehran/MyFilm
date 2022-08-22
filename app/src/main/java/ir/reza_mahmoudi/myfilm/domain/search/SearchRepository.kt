package ir.reza_mahmoudi.myfilm.domain.search

import ir.reza_mahmoudi.myfilm.domain.search.entity.MovieItem
import ir.reza_mahmoudi.myfilm.util.NetworkResult
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun searchMovie(text: String) : Flow<NetworkResult<List<MovieItem>>>
}