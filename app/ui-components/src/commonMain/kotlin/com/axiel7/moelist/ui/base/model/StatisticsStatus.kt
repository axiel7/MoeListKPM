package com.axiel7.moelist.ui.base.model

import com.axiel7.moelist.data.model.media.StatisticsStatus

fun StatisticsStatus.toStats() = listOf(
    Stat(
        type = ListStatus.WATCHING,
        value = watching.toFloatOrNull() ?: 0f
    ),
    Stat(
        type = ListStatus.COMPLETED,
        value = completed.toFloatOrNull() ?: 0f
    ),
    Stat(
        type = ListStatus.ON_HOLD,
        value = onHold.toFloatOrNull() ?: 0f
    ),
    Stat(
        type = ListStatus.DROPPED,
        value = dropped.toFloatOrNull() ?: 0f
    ),
    Stat(
        type = ListStatus.PLAN_TO_WATCH,
        value = planToWatch.toFloatOrNull() ?: 0f
    )
).sortedByDescending { it.value }