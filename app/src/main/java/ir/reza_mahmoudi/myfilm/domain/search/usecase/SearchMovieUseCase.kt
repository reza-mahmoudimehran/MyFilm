package ir.reza_mahmoudi.myfilm.domain.search.usecase

import ir.reza_mahmoudi.myfilm.domain.search.SearchRepository
import ir.reza_mahmoudi.myfilm.domain.search.entity.MovieItem
import ir.reza_mahmoudi.myfilm.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMovieUseCase  @Inject constructor(private val searchRepository: SearchRepository) {
    suspend fun invoke(text: String) : Flow<NetworkResult<List<MovieItem>>> {
        return searchRepository.searchMovie(text)
    }
}