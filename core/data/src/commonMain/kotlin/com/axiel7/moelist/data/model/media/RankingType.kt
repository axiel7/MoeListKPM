package com.axiel7.moelist.data.model.media

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.airing
import com.axiel7.moelist.ui.generated.resources.favorite
import com.axiel7.moelist.ui.generated.resources.popularity
import com.axiel7.moelist.ui.generated.resources.sort_score
import com.axiel7.moelist.ui.generated.resources.upcoming
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

@Serializable
enum class RankingType : Localizable {
    @SerialName("all")
    SCORE,

    @SerialName("bypopularity")
    POPULARITY,

    @SerialName("favorite")
    FAVORITE,

    @SerialName("upcoming")
    UPCOMING,

    @SerialName("airing")
    AIRING;

    @Composable
    override fun localized() = stringResource(stringRes)

    val stringRes
        get() = when (this) {
            SCORE -> UiRes.string.sort_score
            POPULARITY -> UiRes.string.popularity
            FAVORITE -> UiRes.string.favorite
            UPCOMING -> UiRes.string.upcoming
            AIRING -> UiRes.string.airing
        }

    val serialName
        get() = when (this) {
            SCORE -> "all"
            POPULARITY -> "bypopularity"
            FAVORITE -> "favorite"
            UPCOMING -> "upcoming"
            AIRING -> "airing"
        }

    companion object {

        val rankingAnimeValues = arrayOf(SCORE, POPULARITY, FAVORITE, UPCOMING)

        val rankingMangaValues = arrayOf(SCORE, POPULARITY, FAVORITE)
    }
}