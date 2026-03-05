package com.axiel7.moelist.data.utils

import com.axiel7.moelist.data.model.anime.Season
import com.axiel7.moelist.data.model.anime.StartSeason
import com.axiel7.moelist.data.model.media.WeekDay
import kotlin.time.Clock
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime

object SeasonCalendar {

    val japanTimeZone = TimeZone.of("Asia/Tokyo")
    private val defaultTimeZone = TimeZone.currentSystemDefault()

    // Get current date/time once for the properties below
    private val nowLocal = Clock.System.now().toLocalDateTime(defaultTimeZone)
    private val nowJapan = Clock.System.now().toLocalDateTime(japanTimeZone)

    /**
     * monthNumber is 1-indexed (1..12) in kotlinx-datetime
     */
    private val month = nowLocal.month.number
    private val weekDay = nowLocal.dayOfWeek

    val currentYear = nowLocal.year

    val currentSeason = when (month) {
        1, 2, 12 -> Season.WINTER
        3, 4, 5 -> Season.SPRING
        6, 7, 8 -> Season.SUMMER
        9, 10, 11 -> Season.FALL
        else -> Season.SPRING
    }

    private val nextSeason = when (currentSeason) {
        Season.WINTER -> Season.SPRING
        Season.SPRING -> Season.SUMMER
        Season.SUMMER -> Season.FALL
        Season.FALL -> Season.WINTER
    }

    private val prevSeason = when (currentSeason) {
        Season.WINTER -> Season.FALL
        Season.SPRING -> Season.WINTER
        Season.SUMMER -> Season.SPRING
        Season.FALL -> Season.SUMMER
    }

    val currentStartSeason = StartSeason(
        // In Calendar (0-indexed), 11 was December. In kotlinx (1-indexed), 12 is December.
        year = if (month == 12) currentYear + 1 else currentYear,
        season = currentSeason
    )

    val nextStartSeason = StartSeason(
        year = if (month == 12) currentYear + 1 else currentYear,
        season = nextSeason
    )

    val prevStartSeason = StartSeason(
        // If Jan or Feb (1 or 2), previous season (Fall/Winter) belongs to previous year
        year = if (month == 1 || month == 2) currentYear - 1 else currentYear,
        season = prevSeason
    )

    val currentWeekday = when (weekDay) {
        DayOfWeek.MONDAY -> WeekDay.MONDAY
        DayOfWeek.TUESDAY -> WeekDay.TUESDAY
        DayOfWeek.WEDNESDAY -> WeekDay.WEDNESDAY
        DayOfWeek.THURSDAY -> WeekDay.THURSDAY
        DayOfWeek.FRIDAY -> WeekDay.FRIDAY
        DayOfWeek.SATURDAY -> WeekDay.SATURDAY
        DayOfWeek.SUNDAY -> WeekDay.SUNDAY
    }

    val currentJapanWeekday = when (nowJapan.dayOfWeek) {
        DayOfWeek.MONDAY -> WeekDay.MONDAY
        DayOfWeek.TUESDAY -> WeekDay.TUESDAY
        DayOfWeek.WEDNESDAY -> WeekDay.WEDNESDAY
        DayOfWeek.THURSDAY -> WeekDay.THURSDAY
        DayOfWeek.FRIDAY -> WeekDay.FRIDAY
        DayOfWeek.SATURDAY -> WeekDay.SATURDAY
        DayOfWeek.SUNDAY -> WeekDay.SUNDAY
    }
}