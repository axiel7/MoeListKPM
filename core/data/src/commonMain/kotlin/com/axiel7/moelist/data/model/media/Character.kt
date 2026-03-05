package com.axiel7.moelist.data.model.media

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.data.utils.unescapeHtml
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.role_main
import com.axiel7.moelist.ui.generated.resources.role_supporting
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

@Serializable
data class Character(
    val node: Node,
    val role: Role? = null,
) {
    @Serializable
    data class Node(
        @SerialName("id")
        val id: Int,
        @SerialName("first_name")
        val firstName: String? = null,
        @SerialName("last_name")
        val lastName: String? = null,
        @SerialName("alternative_name")
        val alternativeName: String? = null,
        @SerialName("main_picture")
        val mainPicture: MainPicture? = null,
        @SerialName("biography")
        val biography: String? = null,
    )

    @Serializable
    enum class Role : Localizable {
        @SerialName("Main")
        MAIN,

        @SerialName("Supporting")
        SUPPORTING;

        @Composable
        override fun localized() = when (this) {
            MAIN -> stringResource(UiRes.string.role_main)
            SUPPORTING -> stringResource(UiRes.string.role_supporting)
        }
    }

    fun fullName(): String {
        // MAL API returns special characters escaped
        val firstNameUnescaped = node.firstName?.unescapeHtml().orEmpty()
        val lastNameUnescaped = node.lastName?.unescapeHtml().orEmpty()
        return "$firstNameUnescaped $lastNameUnescaped"
    }
}
