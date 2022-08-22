package ir.reza_mahmoudi.myfilm.presentation.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import ir.reza_mahmoudi.myfilm.R
import ir.reza_mahmoudi.myfilm.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        loadAnimation()
        goToHome()
        return binding.root
    }
    private fun loadAnimation(){
        binding.loadingAnimation.setAnimation("loading_animation.json")
        binding.loadingAnimation.playAnimation()
    }
    private fun goToHome(){
        lifecycleScope.launchWhenResumed {
            // TODO change splash delay Time
            delay(5)
            findNavController().navigate(R.id.action_splashFragment_to_searchFragment)
        }
    }
}