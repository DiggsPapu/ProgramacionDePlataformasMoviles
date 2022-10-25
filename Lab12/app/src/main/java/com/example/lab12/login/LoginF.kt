package com.example.lab12.login

import android.os.Bundle

import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.lab12.R
import com.example.lab12.ViewModelSession
import com.example.lab12.databinding.FragmentLoginBinding
import com.example.lab12.util.visibleIf
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginF : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val sessionViewModel: ViewModelSession by activityViewModels()
    private lateinit var job: Job
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservables()
        setListeners()
    }
    private fun setListeners() {
        binding.btnLoginFSave.setOnClickListener {
            sessionViewModel.login(
                email = binding.inputLayoutLoginFragmentEmail.editText!!.text.toString(),
                password = binding.inputLayoutLoginFragmentPassword.editText!!.text.toString()
            )
        }
    }

    private fun setObservables() {
        job = lifecycleScope.launchWhenStarted {
            sessionViewModel.loginStatus.collectLatest { state ->
                handleLoginState(state)
            }
        }
    }

    private fun handleLoginState(state: ViewModelSession.LoginState) {
        when(state) {
            ViewModelSession.LoginState.Default -> {
                binding.progressLoginFragment.visibleIf(false)
                binding.btnLoginFSave.visibleIf(true)
            }
            is ViewModelSession.LoginState.Error -> {
                binding.progressLoginFragment.visibleIf(false)
                binding.btnLoginFSave.visibleIf(true)
                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
            }
            ViewModelSession.LoginState.Loading -> {
                binding.progressLoginFragment.visibleIf(true)
                binding.btnLoginFSave.visibility = View.INVISIBLE
            }
            ViewModelSession.LoginState.Success -> {
                sessionViewModel.generateToken()
                job.cancel()
                requireView().findNavController().navigate(R.id.homeF)
            }
        }
    }
}