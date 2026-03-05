package com.axiel7.moelist.data.model.anime

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.data.utils.SeasonCalendar
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.current_season
import com.axiel7.moelist.ui.generated.resources.next_season
import com.axiel7.moelist.ui.generated.resources.previous_season
import org.jetbrains.compose.resources.stringResource

enum class SeasonType : Localizable {
    PREVIOUS,
    CURRENT,
    NEXT;

    @Composable
    override fun localized() = when (this) {
        PREVIOUS -> stringResource(UiRes.string.previous_season)
        CURRENT -> stringResource(UiRes.string.current_season)
        NEXT -> stringResource(UiRes.string.next_season)
    }

    val season
        get() = when (this) {
            PREVIOUS -> SeasonCalendar.prevStartSeason
            CURRENT -> SeasonCalendar.currentStartSeason
            NEXT -> SeasonCalendar.nextStartSeason
        }
}