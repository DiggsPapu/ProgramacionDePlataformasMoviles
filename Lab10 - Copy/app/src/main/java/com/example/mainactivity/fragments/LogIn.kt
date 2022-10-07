package com.example.mainactivity.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mainactivity.R
import com.example.mainactivity.data.datasource.util.dataStoree
import com.example.mainactivity.data.datasource.util.getValue
import com.example.mainactivity.data.datasource.util.mail
import com.example.mainactivity.data.datasource.util.saveValue
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.*


class LogIn : Fragment(R.layout.fragment_log_in) {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var logIn: Button
    private lateinit var label: TextView
    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = view.findViewById(R.id.correo_inputlayout_login)
        password = view.findViewById(R.id.password_inputlayout_login)
        logIn = view.findViewById(R.id.btn_LogIn_LoginF)
        label = view.findViewById(R.id.mail_password_txt_loginF)
        navController = findNavController()
        val appbarconfig = AppBarConfiguration(navController.graph)
        toolbar = view.findViewById(R.id.toolbar_MainAct)
        toolbar.setupWithNavController(navController, appbarconfig)
        isLogged()
        setListeners()
    }

    private fun setListeners() {
        logIn.setOnClickListener {
            if (email.text.toString().equals(password.text.toString()) and email.text.toString().equals(label.text.toString())){
                CoroutineScope(Dispatchers.IO).launch {
                    requireContext().dataStoree.saveValue(mail, email.text.toString())

                }
                CoroutineScope(Dispatchers.Main).launch {
                    requireView().findNavController().navigate(LogInDirections.actionLogInToCharactersFragment2())
                }
            }
            else{
                Toast.makeText(requireContext(), "The values are not correct", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isLogged(){
        CoroutineScope(Dispatchers.IO).launch {
            if (requireContext().dataStoree.getValue(mail) != null) {
                CoroutineScope(Dispatchers.Main).launch {
                    requireView().findNavController().navigate(LogInDirections.actionLogInToCharactersFragment2())
                }
            }
        }
    }
}

