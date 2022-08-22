package ir.reza_mahmoudi.myfilm.presentation.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.reza_mahmoudi.myfilm.domain.search.entity.MovieItem
import ir.reza_mahmoudi.myfilm.domain.search.usecase.SearchMovieUseCase
import ir.reza_mahmoudi.myfilm.util.NetworkResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase
): ViewModel(){
    val movieList: MutableLiveData<List<MovieItem>> = MutableLiveData()
    fun searchMovie(text: String){
        viewModelScope.launch {
            searchMovieUseCase.invoke(text)
                .collect { result ->
                    when(result){
                        is NetworkResult.Success -> {
                            movieList.value = result.data!!
                        }
                        is NetworkResult.Error -> {
                            Log.e("searchMovie Error",result.message.toString())
                        }
                    }
                }
        }
    }
}