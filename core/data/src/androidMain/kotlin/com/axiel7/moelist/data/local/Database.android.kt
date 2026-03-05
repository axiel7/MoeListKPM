package com.axiel7.moelist.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<MoeListDatabase> {
    val appContext = context.applicationContext
    return Room.databaseBuilder<MoeListDatabase>(
        context = appContext,
        name = "moelist-database"
    )
}