package br.com.emanuel.desafiomarvelhqs.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import br.com.emanuel.desafiomarvelhqs.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        removeSplashScreenOfBackStack()
    }

    private fun removeSplashScreenOfBackStack() {
        Navigation.findNavController(requireView()).popBackStack(
            R.id.splashFragment, true)
    }

}