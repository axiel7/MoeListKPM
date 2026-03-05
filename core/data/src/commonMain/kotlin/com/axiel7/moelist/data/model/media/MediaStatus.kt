package com.axiel7.moelist.data.model.media

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.airing
import com.axiel7.moelist.ui.generated.resources.discontinued
import com.axiel7.moelist.ui.generated.resources.finished
import com.axiel7.moelist.ui.generated.resources.not_yet_aired
import com.axiel7.moelist.ui.generated.resources.on_hiatus
import com.axiel7.moelist.ui.generated.resources.publishing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

@Serializable
enum class MediaStatus : Localizable {
    @SerialName("currently_airing")
    AIRING,

    @SerialName("finished_airing")
    FINISHED_AIRING,

    @SerialName("not_yet_aired")
    NOT_AIRED,

    @SerialName("currently_publishing")
    PUBLISHING,

    @SerialName("finished")
    FINISHED,

    @SerialName("on_hiatus")
    HIATUS,

    @SerialName("discontinued")
    DISCONTINUED;

    @Composable
    override fun localized() = when (this) {
        AIRING -> stringResource(UiRes.string.airing)
        FINISHED_AIRING -> stringResource(UiRes.string.finished)
        NOT_AIRED -> stringResource(UiRes.string.not_yet_aired)
        PUBLISHING -> stringResource(UiRes.string.publishing)
        FINISHED -> stringResource(UiRes.string.finished)
        HIATUS -> stringResource(UiRes.string.on_hiatus)
        DISCONTINUED -> stringResource(UiRes.string.discontinued)
    }
}