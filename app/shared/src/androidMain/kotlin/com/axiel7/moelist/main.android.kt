package com.axiel7.moelist

import android.content.Context
import com.axiel7.moelist.data.local.createDataStore
import com.axiel7.moelist.data.local.getDatabaseBuilder

fun initApp(context: Context) = initApp(
    databaseBuilder = getDatabaseBuilder(context),
    createDataStore = { createDataStore(context, it) },
)