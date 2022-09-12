package com.durini.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var text: EditText
    private lateinit var button: Button
    private val args: HomeFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text = view.findViewById(R.id.textInputEdit_FProfile_input)
        button = view.findViewById(R.id.btn_FProfile_rLogin)
        var email = args.email
        text.setText(email)
        setListeners()
    }

    private fun setListeners() {
        button.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment()
            requireView().findNavController().navigate(action)
        }
    }
}