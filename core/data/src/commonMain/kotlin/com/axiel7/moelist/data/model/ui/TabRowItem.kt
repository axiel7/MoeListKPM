package com.axiel7.moelist.data.model.ui

import androidx.compose.runtime.Stable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

@Stable
data class TabRowItem<T>(
    val value: T,
    val title: StringResource?,
    val icon: DrawableResource? = null,
)
