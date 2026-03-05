package com.axiel7.moelist.data.model.anime

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.game
import com.axiel7.moelist.ui.generated.resources.light_novel
import com.axiel7.moelist.ui.generated.resources.manga
import com.axiel7.moelist.ui.generated.resources.mixed_media
import com.axiel7.moelist.ui.generated.resources.music
import com.axiel7.moelist.ui.generated.resources.novel
import com.axiel7.moelist.ui.generated.resources.original
import com.axiel7.moelist.ui.generated.resources.visual_novel
import com.axiel7.moelist.ui.generated.resources.web_manga
import com.axiel7.moelist.ui.generated.resources.web_novel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

@Serializable
enum class AnimeSource : Localizable {
    @SerialName("original")
    ORIGINAL,

    @SerialName("manga")
    MANGA,

    @SerialName("novel")
    NOVEL,

    @SerialName("light_novel")
    LIGHT_NOVEL,

    @SerialName("visual_novel")
    VISUAL_NOVEL,

    @SerialName("game")
    GAME,

    @SerialName("web_manga")
    WEB_MANGA,

    @SerialName("web_novel")
    WEB_NOVEL,

    @SerialName("music")
    MUSIC,

    @SerialName("mixed_media")
    MIXED_MEDIA,

    @SerialName("4_koma_manga")
    YONKOMA_MANGA;

    @Composable
    override fun localized() = when (this) {
        ORIGINAL -> stringResource(UiRes.string.original)
        MANGA -> stringResource(UiRes.string.manga)
        NOVEL -> stringResource(UiRes.string.novel)
        LIGHT_NOVEL -> stringResource(UiRes.string.light_novel)
        VISUAL_NOVEL -> stringResource(UiRes.string.visual_novel)
        GAME -> stringResource(UiRes.string.game)
        WEB_MANGA -> stringResource(UiRes.string.web_manga)
        WEB_NOVEL -> stringResource(UiRes.string.web_novel)
        MUSIC -> stringResource(UiRes.string.music)
        MIXED_MEDIA -> stringResource(UiRes.string.mixed_media)
        YONKOMA_MANGA -> "4-Koma ${stringResource(UiRes.string.manga)}"
    }
}