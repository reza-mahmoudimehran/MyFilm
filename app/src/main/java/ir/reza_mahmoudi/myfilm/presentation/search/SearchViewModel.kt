package ir.reza_mahmoudi.myfilm.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.reza_mahmoudi.myfilm.domain.search.entity.MovieItem
import ir.reza_mahmoudi.myfilm.domain.search.usecase.SearchMovieUseCase
import ir.reza_mahmoudi.myfilm.util.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase
): ViewModel(){
    val movieList: MutableLiveData<List<MovieItem>> = MutableLiveData()

    val state = MutableLiveData<SearchFragmentState>(SearchFragmentState.Init)

    fun searchMovie(text: String){
        viewModelScope.launch {
            searchMovieUseCase.invoke(text)
                .onStart {
                    state.value=SearchFragmentState.IsLoading(true)
                }
                .catch { exception ->
                    state.value=SearchFragmentState.IsLoading(false)
                    state.value=SearchFragmentState.ShowErrorMessage(exception.message.toString())
                }
                .collect { result ->
                    state.value=SearchFragmentState.IsLoading(false)
                    when(result){
                        is NetworkResult.Success -> {
                            movieList.value = result.data!!
                        }
                        is NetworkResult.Error -> {
                            state.value=SearchFragmentState.ShowErrorMessage(result.message.toString())
                        }
                    }
                }
        }
    }
}


sealed class SearchFragmentState {
    object Init : SearchFragmentState()
    data class IsLoading(val isLoading: Boolean) : SearchFragmentState()
    data class ShowErrorMessage(val message : String) : SearchFragmentState()
}