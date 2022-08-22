package ir.reza_mahmoudi.myfilm.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.reza_mahmoudi.myfilm.databinding.FragmentSearchBinding
import ir.reza_mahmoudi.myfilm.util.showToast

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var moviesAdapter:MoviesListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        observeViewModel()
    }
    private fun initViews(){
        moviesAdapter=MoviesListAdapter()

        binding.moviesList.apply {
            layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
            adapter=moviesAdapter
        }
        binding.searchButton.setOnClickListener {
            search()
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing=false
            search()
        }
    }
    private fun search(){
        val text=binding.searchText.text.toString()
        if (text==""){
            requireActivity().showToast("Please Enter Search Text")
        }else{
            binding.loadingAnimation.visibility=View.VISIBLE
            playLoadingAnimation()
            viewModel.searchMovie(text)
        }

    }
    private fun playLoadingAnimation(){
        binding.loadingAnimation.setAnimation("loading_animation.json")
        binding.loadingAnimation.playAnimation()
    }
    private fun observeViewModel(){
        viewModel.movieList.observe(viewLifecycleOwner){
            it?.let {
                binding.moviesList.visibility = View.VISIBLE
                binding.loadingAnimation.visibility=View.GONE
                moviesAdapter.setData(it)
            }
        }

        viewModel.state.observe(viewLifecycleOwner) {
            when(it){
                is SearchFragmentState.IsLoading -> {
                    if (it.isLoading) {
                        binding.errorMessage.visibility = View.GONE
                        binding.moviesList.visibility = View.GONE
                    }
                }
                is SearchFragmentState.ShowErrorMessage -> {
                    binding.errorMessage.visibility = View.VISIBLE
                    binding.loadingAnimation.visibility=View.GONE
                    requireActivity().showToast(it.message)
                }
                is SearchFragmentState.Init -> Unit
            }
        }
    }
}