package com.axiel7.moelist

import com.axiel7.moelist.data.local.createDataStore
import com.axiel7.moelist.data.local.getDatabaseBuilder
import com.axiel7.moelist.data.utils.LOCAL_AUTH_PORT
import org.publicvalue.multiplatform.oidc.ExperimentalOpenIdConnect
import org.publicvalue.multiplatform.oidc.appsupport.JvmCodeAuthFlowFactory
import org.publicvalue.multiplatform.oidc.appsupport.webserver.SimpleKtorWebserver
import org.publicvalue.multiplatform.oidc.tokenstore.TokenStore

@OptIn(ExperimentalOpenIdConnect::class)
fun initApp(tokenStore: TokenStore) = initApp(
    tokenStore = tokenStore,
    codeAuthFlowFactory = JvmCodeAuthFlowFactory(
        webserverProvider = {
            SimpleKtorWebserver(port = LOCAL_AUTH_PORT)
        }
    ),
    databaseBuilder = getDatabaseBuilder(),
    createDataStore = { createDataStore(it) },
)