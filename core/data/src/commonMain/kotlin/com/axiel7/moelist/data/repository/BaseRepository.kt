package com.axiel7.moelist.data.repository

import com.axiel7.moelist.data.GlobalVariables
import com.axiel7.moelist.data.network.Api
import com.axiel7.moelist.data.network.KtorClient
import kotlinx.coroutines.flow.first

abstract class BaseRepository(
    private val globalVariables: GlobalVariables,
    private val api: Api,
    private val defaultPreferencesRepository: DefaultPreferencesRepository
) {
    /**
     * @return `true` if should retry the call
     */
    suspend fun handleResponseError(error: String): Boolean {
        when (error) {
            "invalid_token" -> {
                val refreshToken = defaultPreferencesRepository.refreshToken.first()
                if (refreshToken != null) {
                    try {
                        val newToken = api.getAccessToken(
                            clientId = KtorClient.CLIENT_ID,
                            refreshToken = refreshToken
                        )
                        defaultPreferencesRepository.saveTokens(newToken)
                        globalVariables.accessToken = newToken.accessToken
                    } catch (_: Exception) {
                        defaultPreferencesRepository.removeTokens()
                    }
                } else {
                    defaultPreferencesRepository.removeTokens()
                }
                return true
            }

            else -> return false
        }
    }
}