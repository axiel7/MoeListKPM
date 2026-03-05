package com.axiel7.moelist.screens.more.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.cancel
import com.axiel7.moelist.ui.generated.resources.discord
import com.axiel7.moelist.ui.generated.resources.github
import com.axiel7.moelist.ui.generated.resources.ic_discord
import com.axiel7.moelist.ui.generated.resources.ic_github
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FeedbackDialog(
    onDismiss: () -> Unit
) {
    //val context = LocalContext.current
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onDismiss,
                shapes = ButtonDefaults.shapes(),
            ) {
                Text(text = stringResource(UiRes.string.cancel))
            }
        },
        text = {
            Column {
                MoreItem(
                    title = stringResource(UiRes.string.github),
                    icon = UiRes.drawable.ic_github,
                    onClick = {
                        //TODO context.openAction(GITHUB_ISSUES_URL)
                    }
                )
                MoreItem(
                    title = stringResource(UiRes.string.discord),
                    icon = UiRes.drawable.ic_discord,
                    onClick = {
                        //TODO context.openAction(DISCORD_SERVER_URL)
                    }
                )
            }
        }
    )
}