package br.com.emanuel.desafiomarvelhqs.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.emanuel.desafiomarvelhqs.R

class LoginFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var btnLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        btnLogin = view.findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            navController.popBackStack(R.id.loginFragment, true)
            navController.navigate(R.id.comicsFragment)
        }

    }

}