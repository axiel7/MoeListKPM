package com.axiel7.moelist.data.model.media

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ListStatusDto {
    @SerialName("watching")
    WATCHING,

    @SerialName("reading")
    READING,

    @SerialName("plan_to_watch")
    PLAN_TO_WATCH,

    @SerialName("plan_to_read")
    PLAN_TO_READ,

    @SerialName("completed")
    COMPLETED,

    @SerialName("on_hold")
    ON_HOLD,

    @SerialName("dropped")
    DROPPED;

    val value get() = name.lowercase()
}
