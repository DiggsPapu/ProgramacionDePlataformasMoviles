package com.example.lab12
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val TOKEN_DURATION = 3000L
private const val LOGIN_TIME = 2000L

class ViewModelSession : ViewModel(){
    sealed interface LoginState {
        object Default: LoginState
        object Success: LoginState
        object Loading: LoginState
        class Error(val message: String): LoginState
    }

    private val autentificationtoken = MutableStateFlow(false)
    val validAuthToken: StateFlow<Boolean> = autentificationtoken

    private val statusLogin = MutableStateFlow<LoginState>(LoginState.Default)
    val loginStatus: StateFlow<LoginState> = statusLogin

    private lateinit var job: Job


    fun login(email: String, password: String) {
        viewModelScope.launch {
            statusLogin.value = LoginState.Loading
            delay(LOGIN_TIME)
            if (email == "alo20172@uvg.edu.gt" && email == password) {
                statusLogin.value = LoginState.Success
            } else {
                statusLogin.value = LoginState.Error("Invalid data entered.")
            }

            statusLogin.value = LoginState.Default
        }
    }

    fun generateToken() {
        job = viewModelScope.launch {
            autentificationtoken.value = true
            delay(TOKEN_DURATION)
            autentificationtoken.value = false
        }
    }

    fun cancelJob() {
        job.cancel()
    }

    fun logOut() {
        job.cancel()
        autentificationtoken.value = false
    }
}