package br.com.emanuel.desafiomarvelhqs.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.emanuel.desafiomarvelhqs.R

class RegisterFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var myToolbar: Toolbar
    private lateinit var imgReturnToLoginScreen: ImageView
    private lateinit var btnRegister: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myToolbar = view.findViewById(R.id.myToolbar)
        activity?.setActionBar(myToolbar)
        activity?.actionBar?.setDisplayShowTitleEnabled(false)

        navController = Navigation.findNavController(view)

        imgReturnToLoginScreen = view.findViewById(R.id.imgReturnToLoginScreen)
        imgReturnToLoginScreen.setOnClickListener {
            navController.popBackStack(R.id.registerFragment, true)
        }

        btnRegister = view.findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            navController.popBackStack(R.id.registerFragment, true)
            navController.popBackStack(R.id.loginFragment, true)
            navController.navigate(R.id.comicsFragment)
        }

    }
}