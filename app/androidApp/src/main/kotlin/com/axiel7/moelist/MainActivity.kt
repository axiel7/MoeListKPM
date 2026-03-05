package com.axiel7.moelist

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.axiel7.moelist.data.repository.LoginRepository
import com.axiel7.moelist.data.utils.MOELIST_PAGELINK
import com.axiel7.moelist.main.MainUiState
import com.axiel7.moelist.main.MainViewModel
import com.axiel7.moelist.ui.base.model.BottomDestination.Companion.toBottomDestinationIndex
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModel<MainViewModel>()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        installSplashScreen()

        checkLoginIntent(intent)

        runBlocking { viewModel.initGlobalVariables() }

        val lastTabOpened = findLastTabOpened()

        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val darkTheme = isSystemInDarkTheme()
            val windowSizeClass = calculateWindowSizeClass(this)

            App(
                dynamicColorSeed = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    if (darkTheme) dynamicDarkColorScheme(this).primary else dynamicLightColorScheme(
                        this
                    ).primary
                } else null,
                uiState = uiState,
                windowWidthSizeClass = windowSizeClass.widthSizeClass,
                lastTabOpened = lastTabOpened,
                saveLastTab = viewModel::saveLastTab,
            )
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        checkLoginIntent(intent)
    }

    private fun checkLoginIntent(intent: Intent?) {
        if (intent?.data?.toString()?.startsWith(MOELIST_PAGELINK) == true) {
            intent.data?.let { parseIntentData(it) }
        }
    }

    private fun parseIntentData(uri: Uri) {
        val code = uri.getQueryParameter("code")
        val receivedState = uri.getQueryParameter("state")
        if (code != null && receivedState == LoginRepository.STATE) {
            viewModel.getAccessToken(code)
        }
    }

    private fun findLastTabOpened(): Int {
        val startTab = runBlocking { viewModel.startTab.first() }
        var lastTabOpened =
            intent.action?.toBottomDestinationIndex() ?: startTab?.value?.toBottomDestinationIndex()

        if (lastTabOpened == null) {
            lastTabOpened = runBlocking { viewModel.lastTab.first() }
        } else { // opened from intent or start tab setting
            viewModel.saveLastTab(lastTabOpened)
        }
        return lastTabOpened
    }
}

@Preview
@Composable
private fun AppAndroidPreview() {
    App(
        uiState = MainUiState(),
        windowWidthSizeClass = WindowWidthSizeClass.Compact,
        lastTabOpened = 0,
        saveLastTab = {},
    )
}