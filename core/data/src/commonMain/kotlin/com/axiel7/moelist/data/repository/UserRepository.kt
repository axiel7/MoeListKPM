package com.axiel7.moelist.data.repository

import com.axiel7.moelist.data.model.Response
import com.axiel7.moelist.data.model.User
import com.axiel7.moelist.data.model.UserStats
import com.axiel7.moelist.data.network.Api
import com.axiel7.moelist.data.network.JikanApi

class UserRepository(
    private val api: Api,
    private val jikanApi: JikanApi,
) {

    companion object {
        private const val USER_FIELDS = "id,name,gender,location,joined_at,anime_statistics"
    }

    suspend fun getMyUser(): User? {
        return try {
            api.getUser(USER_FIELDS)
        } catch (_: Exception) {
            null
        }
    }

    suspend fun getUserStats(
        username: String
    ): Response<UserStats> {
        return try {
            jikanApi.getUserStats(username)
        } catch (e: Exception) {
            Response(message = e.message)
        }
    }
}