package com.axiel7.moelist.data.local

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

object DatabaseConverters {
    @TypeConverter
    fun timestampToLocalDateTime(value: Long?): LocalDateTime? {
        return value?.let {
            Instant.fromEpochMilliseconds(it)
                .toLocalDateTime(TimeZone.currentSystemDefault())
        }
    }

    @TypeConverter
    fun localDateTimeToTimestamp(value: LocalDateTime?): Long? {
        return value
            ?.toInstant(TimeZone.currentSystemDefault())
            ?.toEpochMilliseconds()
    }
}
