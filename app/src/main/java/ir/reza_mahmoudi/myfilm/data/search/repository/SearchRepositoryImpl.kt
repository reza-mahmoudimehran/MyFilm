package ir.reza_mahmoudi.myfilm.data.search.repository

import ir.reza_mahmoudi.myfilm.data.search.remote.SearchApi
import ir.reza_mahmoudi.myfilm.domain.search.SearchRepository
import ir.reza_mahmoudi.myfilm.domain.search.entity.MovieItem
import ir.reza_mahmoudi.myfilm.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchApi: SearchApi) : SearchRepository {
    override suspend fun searchMovie(text: String): Flow<NetworkResult<List<MovieItem>>> {
        return flow {
            val response = searchApi.searchMovie(text)
            if (response.isSuccessful){
                val body = response.body()!!
                emit(NetworkResult.Success(body.movieList))
            }else{
                emit(NetworkResult.Error(response.errorBody().toString()))
            }
        }
    }
}