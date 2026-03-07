package com.axiel7.moelist.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axiel7.moelist.data.network.OAuthService
import kotlinx.coroutines.launch

class LoginViewModel(
    private val oAuthService: OAuthService,
) : ViewModel(), LoginEvent {

    override fun openLogin() {
        viewModelScope.launch {
            oAuthService.login()
        }
    }
}