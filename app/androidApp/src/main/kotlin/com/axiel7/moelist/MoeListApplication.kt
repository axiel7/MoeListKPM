package com.axiel7.moelist

import android.app.Application
import org.publicvalue.multiplatform.oidc.appsupport.AndroidCodeAuthFlowFactory

class MoeListApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initApp(
            context = applicationContext,
            codeAuthFlowFactory = AndroidCodeAuthFlowFactory()
        )
    }
}
