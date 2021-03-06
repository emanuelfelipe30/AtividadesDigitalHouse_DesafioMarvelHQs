package br.com.emanuel.desafiomarvelhqs.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.emanuel.desafiomarvelhqs.R

const val SPLASH_DURATION = 4000L

class SplashFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        closeSplashScreen()
    }

    private fun closeSplashScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.popBackStack(R.id.splashFragment, true)
            navController.navigate(R.id.loginFragment)
        }, SPLASH_DURATION)
    }

}