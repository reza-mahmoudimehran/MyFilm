package ir.reza_mahmoudi.myfilm.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.reza_mahmoudi.myfilm.databinding.FragmentSearchBinding
import ir.reza_mahmoudi.myfilm.util.showLog

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
    }
    private fun observeViewModel(){
        viewModel.searchMovie("car")
        viewModel.movieList.observe(viewLifecycleOwner){
            showLog("searchMovie List",it.toString())
        }
    }
}