package com.example.lab12.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.lab12.R
import com.example.lab12.ViewModelSession
import com.example.lab12.databinding.FragmentHomeBinding
import com.example.lab12.login.LoginF
import com.example.lab12.util.visibleIf
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest


class HomeF : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val sessionVM: ViewModelSession by activityViewModels()
    private val homeVM: ViewModelH by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    private fun setListeners() {
        binding.apply {
            btnHomeFDefault.setOnClickListener {
                homeVM.changeState(ViewModelH.HomeViewState.Default)
            }

            btnHomeFSuccess.setOnClickListener {
                homeVM.changeState(ViewModelH.HomeViewState.Success)
            }

            btnHomeFFail.setOnClickListener {
                homeVM.changeState(ViewModelH.HomeViewState.Failure)
            }

            btnHomeFEmpty.setOnClickListener {
                homeVM.changeState(ViewModelH.HomeViewState.Empty)
            }

            btnHomeFKeepsession.setOnClickListener {
                sessionVM.cancelJob()
            }

            btnHomeFLogout.setOnClickListener {
                sessionVM.logOut()
            }
        }
    }

    private fun setObservables() {
        lifecycleScope.launchWhenStarted {
            sessionVM.validAuthToken.collectLatest { isValid ->
                if (!isValid) {
                    Toast.makeText(requireContext(), "logout", Toast.LENGTH_SHORT).show()
                    requireActivity().onBackPressed()
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            homeVM.homeState.collectLatest { state ->
                handleHomeState(state)
            }
        }

    }

    private fun handleHomeState(state: ViewModelH.HomeViewState) {
        when(state) {
            ViewModelH.HomeViewState.Default -> {
                setStateLoading(false)
                enableButtons()
                binding.ivHomeFFinal.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_android_black_24dp)
                )
                binding.txtvHomeFDescr.text = "Options"
            }

            ViewModelH.HomeViewState.Empty -> {
                setStateLoading(false)
                enableButtons()
                binding.ivHomeFFinal.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_hourglass_empty_24)
                )
                binding.txtvHomeFDescr.text = "No results"
            }

            ViewModelH.HomeViewState.Failure -> {
                setStateLoading(false)
                enableButtons()
                binding.ivHomeFFinal.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_sms_failed_24)
                )
                binding.txtvHomeFDescr.text = "Failed"
            }

            ViewModelH.HomeViewState.Success -> {
                setStateLoading(false)
                enableButtons()
                binding.ivHomeFFinal.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_check_24)
                )
                binding.txtvHomeFDescr.text = "Success!"
            }

            is ViewModelH.HomeViewState.Loading -> {
                setStateLoading(true)
                binding.btnHomeFDefault.isEnabled = state.currentState == ViewModelH.HomeViewState.Default
                binding.btnHomeFSuccess.isEnabled = state.currentState == ViewModelH.HomeViewState.Success
                binding.btnHomeFFail.isEnabled = state.currentState == ViewModelH.HomeViewState.Failure
                binding.btnHomeFEmpty.isEnabled = state.currentState == ViewModelH.HomeViewState.Empty
            }
        }
    }

    private fun setStateLoading(isLoading: Boolean) {
        binding.progressHomeFragment.visibleIf(isLoading)
        binding.ivHomeFFinal.visibleIf(!isLoading)
        binding.txtvHomeFDescr.visibleIf(!isLoading)
    }

    private fun enableButtons() {
        binding.btnHomeFDefault.isEnabled = true
        binding.btnHomeFEmpty.isEnabled = true
        binding.btnHomeFFail.isEnabled = true
        binding.btnHomeFSuccess.isEnabled = true
    }

}