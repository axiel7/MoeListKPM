package com.axiel7.moelist.data.model.media

import androidx.compose.runtime.Composable
import com.axiel7.moelist.data.model.base.Localizable
import com.axiel7.moelist.ui.generated.resources.UiRes
import com.axiel7.moelist.ui.generated.resources.adaptation
import com.axiel7.moelist.ui.generated.resources.full_story
import com.axiel7.moelist.ui.generated.resources.parent_story
import com.axiel7.moelist.ui.generated.resources.relation_alternative_setting
import com.axiel7.moelist.ui.generated.resources.relation_alternative_version
import com.axiel7.moelist.ui.generated.resources.relation_character
import com.axiel7.moelist.ui.generated.resources.relation_other
import com.axiel7.moelist.ui.generated.resources.relation_prequel
import com.axiel7.moelist.ui.generated.resources.relation_sequel
import com.axiel7.moelist.ui.generated.resources.relation_side_story
import com.axiel7.moelist.ui.generated.resources.relation_spin_off
import com.axiel7.moelist.ui.generated.resources.relation_summary
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

@Serializable
enum class RelationType : Localizable {
    @SerialName("prequel")
    PREQUEL,

    @SerialName("sequel")
    SEQUEL,

    @SerialName("summary")
    SUMMARY,

    @SerialName("alternative_version")
    ALTERNATIVE_VERSION,

    @SerialName("alternative_setting")
    ALTERNATIVE_SETTING,

    @SerialName("spin_off")
    SPIN_OFF,

    @SerialName("side_story")
    SIDE_STORY,

    @SerialName("parent_story")
    PARENT_STORY,

    @SerialName("full_story")
    FULL_STORY,

    @SerialName("adaptation")
    ADAPTATION,

    @SerialName("character")
    CHARACTER,

    @SerialName("other")
    OTHER;

    @Composable
    override fun localized() = when (this) {
        PREQUEL -> stringResource(UiRes.string.relation_prequel)
        SEQUEL -> stringResource(UiRes.string.relation_sequel)
        SUMMARY -> stringResource(UiRes.string.relation_summary)
        ALTERNATIVE_VERSION -> stringResource(UiRes.string.relation_alternative_version)
        ALTERNATIVE_SETTING -> stringResource(UiRes.string.relation_alternative_setting)
        SPIN_OFF -> stringResource(UiRes.string.relation_spin_off)
        SIDE_STORY -> stringResource(UiRes.string.relation_side_story)
        PARENT_STORY -> stringResource(UiRes.string.parent_story)
        FULL_STORY -> stringResource(UiRes.string.full_story)
        ADAPTATION -> stringResource(UiRes.string.adaptation)
        CHARACTER -> stringResource(UiRes.string.relation_character)
        OTHER -> stringResource(UiRes.string.relation_other)
    }
}