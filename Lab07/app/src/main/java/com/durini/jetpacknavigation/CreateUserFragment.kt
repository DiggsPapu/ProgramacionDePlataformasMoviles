package com.durini.jetpacknavigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import java.util.regex.Matcher
import java.util.regex.Pattern


class CreateUserFragment : Fragment(R.layout.fragment_create_user) {

    private lateinit var buttonCreate: Button
    private lateinit var createUserTextView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createUserTextView = view.findViewById(R.id.textedit_fragmentCreateUser_input)
        buttonCreate = view.findViewById(R.id.button_createFragment_home)
        setListeners()
    }

    private fun setListeners() {
        buttonCreate.setOnClickListener {
            if ( isEmailValid(createUserTextView.text.toString())){
                val action = CreateUserFragmentDirections.actionCreateUserFragmentToHomeFragment(
                    email = createUserTextView.text.toString()
                )
                requireView().findNavController().navigate(action)
            }
            else{
                Toast.makeText(activity, "The email entered is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
//    This code was gotten from https://stackoverflow.com/questions/6119722/how-to-check-edittexts-text-is-email-address-or-not
    private fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
}