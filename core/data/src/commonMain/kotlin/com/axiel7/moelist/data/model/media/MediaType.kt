package com.axiel7.moelist.data.model.media

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.anime
import com.axiel7.moelist.ui.generated.resources.manga
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

@Serializable
enum class MediaType : Localizable {
    ANIME, MANGA;

    @Composable
    override fun localized() = when (this) {
        ANIME -> stringResource(UiRes.string.anime)
        MANGA -> stringResource(UiRes.string.manga)
    }
}