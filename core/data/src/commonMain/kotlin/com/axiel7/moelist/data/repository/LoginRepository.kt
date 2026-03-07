package com.axiel7.moelist.data.repository

import com.axiel7.moelist.data.network.OAuthService

class LoginRepository(
    private val oAuthService: OAuthService,
    private val defaultPreferencesRepository: DefaultPreferencesRepository
) {
    suspend fun removeOldData() {
        defaultPreferencesRepository.removeTokens()
    }

    suspend fun logOut() {
        oAuthService.logOut()
        defaultPreferencesRepository.setProfilePicture(null)
    }
}