package com.axiel7.moelist.data.model.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.axiel7.moelist.data.model.BaseResponse
import com.axiel7.moelist.data.utils.NumExtensions.isGreaterThanZero
import com.axiel7.moelist.data.utils.unescapeHtml
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.high_value
import com.axiel7.moelist.ui.generated.resources.low_value
import com.axiel7.moelist.ui.generated.resources.medium_value
import com.axiel7.moelist.ui.generated.resources.score_apalling
import com.axiel7.moelist.ui.generated.resources.score_average
import com.axiel7.moelist.ui.generated.resources.score_bad
import com.axiel7.moelist.ui.generated.resources.score_fine
import com.axiel7.moelist.ui.generated.resources.score_good
import com.axiel7.moelist.ui.generated.resources.score_great
import com.axiel7.moelist.ui.generated.resources.score_horrible
import com.axiel7.moelist.ui.generated.resources.score_masterpiece
import com.axiel7.moelist.ui.generated.resources.score_very_bad
import com.axiel7.moelist.ui.generated.resources.score_very_good
import com.axiel7.moelist.ui.generated.resources.unknown
import com.axiel7.moelist.ui.generated.resources.very_high_value
import com.axiel7.moelist.ui.generated.resources.very_low_value
import org.jetbrains.compose.resources.stringResource

@Stable
abstract class BaseMyListStatus : BaseResponse {
    abstract val status: ListStatusDto
    abstract val score: Int
    abstract val updatedAt: String?
    abstract val startDate: String?
    abstract val finishDate: String?
    abstract val progress: Int?
    abstract val repeatCount: Int?
    abstract val repeatValue: Int?
    abstract val isRepeating: Boolean
    abstract val priority: Int
    abstract val tags: List<String>?
    abstract val comments: String?

    override val error: String? = null
    override val message: String? = null

    fun hasRepeated() = isRepeating || repeatCount.isGreaterThanZero()

    fun hasNotes() = !comments.isNullOrBlank() || !tags.isNullOrEmpty()

    // MAL API returns special characters escaped
    fun notesEscaped(): String? = comments?.unescapeHtml()
        ?.replace("<br />", "")
}

@Composable
fun Int.scoreText() = when (this) {
    0 -> ""
    1 -> stringResource(UiRes.string.score_apalling)
    2 -> stringResource(UiRes.string.score_horrible)
    3 -> stringResource(UiRes.string.score_very_bad)
    4 -> stringResource(UiRes.string.score_bad)
    5 -> stringResource(UiRes.string.score_average)
    6 -> stringResource(UiRes.string.score_fine)
    7 -> stringResource(UiRes.string.score_good)
    8 -> stringResource(UiRes.string.score_very_good)
    9 -> stringResource(UiRes.string.score_great)
    10 -> stringResource(UiRes.string.score_masterpiece)
    else -> ""
}

@Composable
fun Int.priorityLocalized() = when (this) {
    0 -> stringResource(UiRes.string.low_value)
    1 -> stringResource(UiRes.string.medium_value)
    2 -> stringResource(UiRes.string.high_value)
    else -> stringResource(UiRes.string.unknown)
}

@Composable
fun Int.repeatValueLocalized() = when (this) {
    0 -> "─"
    1 -> stringResource(UiRes.string.very_low_value)
    2 -> stringResource(UiRes.string.low_value)
    3 -> stringResource(UiRes.string.medium_value)
    4 -> stringResource(UiRes.string.high_value)
    5 -> stringResource(UiRes.string.very_high_value)
    else -> stringResource(UiRes.string.unknown)
}
