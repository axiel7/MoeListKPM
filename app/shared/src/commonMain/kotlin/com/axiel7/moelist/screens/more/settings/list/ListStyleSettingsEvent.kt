package com.axiel7.moelist.screens.more.settings.list

import androidx.compose.runtime.Stable
import com.axiel7.moelist.data.model.media.MediaType
import com.axiel7.moelist.data.model.ui.ListStyle
import com.axiel7.moelist.ui.base.model.ListStatus
import kotlinx.coroutines.flow.StateFlow

@Stable
interface ListStyleSettingsEvent {
    fun getListStyle(mediaType: MediaType, status: ListStatus): StateFlow<ListStyle?>
    fun setListStyle(mediaType: MediaType, status: ListStatus, value: ListStyle)
}