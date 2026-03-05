package com.axiel7.moelist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.rememberNavBackStack
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.crossfade
import com.axiel7.moelist.data.model.ui.TabletMode
import com.axiel7.moelist.main.MainUiState
import com.axiel7.moelist.main.MainView
import com.axiel7.moelist.main.MainViewModel
import com.axiel7.moelist.ui.base.model.BottomDestination
import com.axiel7.moelist.ui.base.model.BottomDestination.Companion.isBottomDestination
import com.axiel7.moelist.ui.base.model.BottomDestination.Companion.toBottomDestinationRoute
import com.axiel7.moelist.ui.base.navigation.NavActionManager.Companion.rememberNavActionManager
import com.axiel7.moelist.ui.base.navigation.NavActionManager.Companion.savedStateConfiguration
import com.axiel7.moelist.ui.base.navigation.TopLevelBackStack
import com.axiel7.moelist.ui.theme.MoeListTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App(
    uiState: MainUiState,
    windowWidthSizeClass: WindowWidthSizeClass,
    lastTabOpened: Int,
    dynamicColorSeed: Color? = null,
    saveLastTab: (Int) -> Unit,
    onThemeChange: ((isDarkTheme: Boolean) -> Unit)? = null
) {
    val startKey = remember(lastTabOpened) {
        lastTabOpened.toBottomDestinationRoute() ?: BottomDestination.Home.route
    }
    val backStack = rememberNavBackStack(configuration = savedStateConfiguration, startKey)
    val topLevelBackStack = remember { TopLevelBackStack(startKey, backStack) }
    val navActionManager = rememberNavActionManager(topLevelBackStack)
    val isBottomDestination by remember {
        derivedStateOf {
            topLevelBackStack.backStack.lastOrNull()?.isBottomDestination() == true
        }
    }
    val isCompactScreen = when (uiState.tabletMode) {
        TabletMode.AUTO -> windowWidthSizeClass == WindowWidthSizeClass.Compact
        TabletMode.ALWAYS -> false
        TabletMode.LANDSCAPE -> windowWidthSizeClass == WindowWidthSizeClass.Compact
        TabletMode.NEVER -> true
    }

    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, percent = 0.25)
                    .build()
            }
            .crossfade(true)
            .build()
    }

    MoeListTheme(
        dynamicColorSeed = dynamicColorSeed
    ) {
        val backgroundColor = MaterialTheme.colorScheme.background
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor
        ) {
            MainView(
                isCompactScreen = isCompactScreen,
                isLoggedIn = !uiState.accessToken.isNullOrEmpty(),
                useListTabs = uiState.useListTabs,
                isBottomDestination = isBottomDestination,
                topLevelBackStack = topLevelBackStack,
                navActionManager = navActionManager,
                saveLastTab = saveLastTab,
                pinnedNavBar = uiState.pinnedNavBar,
                profilePicture = uiState.profilePicture,
            )
        }
    }
}