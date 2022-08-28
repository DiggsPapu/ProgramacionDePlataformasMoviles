package com.durini.jetpacknavigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var buttonLogin: Button
    private lateinit var editText: EditText
    private lateinit var createUserTextView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin = view.findViewById(R.id.button_loginFragment_home)
        editText = view.findViewById(R.id.TextInputEdit_FMain_Input)
        createUserTextView = view.findViewById(R.id.text_fragmentHome_createUser)
        setListeners()
    }

    private fun setListeners() {
        buttonLogin.setOnClickListener {
            if (editText.text.toString().equals("jcdurini@uvg.edu.gt")){
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                    email = editText.text.toString()
                )
                requireView().findNavController().navigate(action)
            }
            else{
                Toast.makeText(activity, "The entered email doesnt exist", Toast.LENGTH_LONG).show()
            }

        }
        createUserTextView.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_loginFragment_to_createUserFragment)
        }
    }
}