package com.axiel7.moelist.data.model.media

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.cm
import com.axiel7.moelist.ui.generated.resources.doujinshi
import com.axiel7.moelist.ui.generated.resources.light_novel
import com.axiel7.moelist.ui.generated.resources.manga
import com.axiel7.moelist.ui.generated.resources.manhua
import com.axiel7.moelist.ui.generated.resources.manhwa
import com.axiel7.moelist.ui.generated.resources.movie
import com.axiel7.moelist.ui.generated.resources.music
import com.axiel7.moelist.ui.generated.resources.novel
import com.axiel7.moelist.ui.generated.resources.ona
import com.axiel7.moelist.ui.generated.resources.one_shot
import com.axiel7.moelist.ui.generated.resources.ova
import com.axiel7.moelist.ui.generated.resources.pv
import com.axiel7.moelist.ui.generated.resources.special
import com.axiel7.moelist.ui.generated.resources.tv
import com.axiel7.moelist.ui.generated.resources.tv_special
import com.axiel7.moelist.ui.generated.resources.unknown
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

@Serializable
enum class MediaFormat : Localizable {
    @SerialName("tv")
    TV,

    @SerialName("tv_special")
    TV_SPECIAL,

    @SerialName("ova")
    OVA,

    @SerialName("ona")
    ONA,

    @SerialName("movie")
    MOVIE,

    @SerialName("special")
    SPECIAL,

    @SerialName("cm")
    CM,

    @SerialName("pv")
    PV,

    @SerialName("music")
    MUSIC,

    @SerialName("manga")
    MANGA,

    @SerialName("one_shot")
    ONE_SHOT,

    @SerialName("manhwa")
    MANHWA,

    @SerialName("manhua")
    MANHUA,

    @SerialName("novel")
    NOVEL,

    @SerialName("light_novel")
    LIGHT_NOVEL,

    @SerialName("doujinshi")
    DOUJINSHI,

    @SerialName("unknown")
    UNKNOWN;

    @Composable
    override fun localized() = when (this) {
        TV -> stringResource(UiRes.string.tv)
        TV_SPECIAL -> stringResource(UiRes.string.tv_special)
        OVA -> stringResource(UiRes.string.ova)
        ONA -> stringResource(UiRes.string.ona)
        MOVIE -> stringResource(UiRes.string.movie)
        SPECIAL -> stringResource(UiRes.string.special)
        CM -> stringResource(UiRes.string.cm)
        PV -> stringResource(UiRes.string.pv)
        MUSIC -> stringResource(UiRes.string.music)
        UNKNOWN -> stringResource(UiRes.string.unknown)
        MANGA -> stringResource(UiRes.string.manga)
        ONE_SHOT -> stringResource(UiRes.string.one_shot)
        MANHWA -> stringResource(UiRes.string.manhwa)
        MANHUA -> stringResource(UiRes.string.manhua)
        NOVEL -> stringResource(UiRes.string.novel)
        LIGHT_NOVEL -> stringResource(UiRes.string.light_novel)
        DOUJINSHI -> stringResource(UiRes.string.doujinshi)
    }
}