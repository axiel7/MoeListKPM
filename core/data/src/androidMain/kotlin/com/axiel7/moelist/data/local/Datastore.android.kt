package com.axiel7.moelist.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

fun createDataStore(context: Context, name: String): DataStore<Preferences> = createDataStore(
    producePath = { context.filesDir.resolve(name).absolutePath }
)