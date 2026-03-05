package com.axiel7.moelist

import com.axiel7.moelist.data.local.createDataStore
import com.axiel7.moelist.data.local.getDatabaseBuilder

fun initApp() = initApp(
    databaseBuilder = getDatabaseBuilder(),
    createDataStore = { createDataStore(it) },
)