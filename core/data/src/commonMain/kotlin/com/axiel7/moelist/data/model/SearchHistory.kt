package com.axiel7.moelist.data.model

import androidx.compose.runtime.Stable
import kotlinx.datetime.LocalDateTime

@Stable
data class SearchHistory(
    val keyword: String,
    val updatedAt: LocalDateTime,
)
