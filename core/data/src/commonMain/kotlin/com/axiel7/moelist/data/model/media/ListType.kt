package com.axiel7.moelist.data.model.media

import com.axiel7.moelist.data.repository.DefaultPreferencesRepository

data class ListType(
    val status: ListStatusDto,
    val mediaType: MediaType,
) {
    fun stylePreference(
        defaultPreferencesRepository: DefaultPreferencesRepository
    ) = when (status) {
        ListStatusDto.WATCHING -> defaultPreferencesRepository.animeCurrentListStyle
        ListStatusDto.READING -> defaultPreferencesRepository.mangaCurrentListStyle
        ListStatusDto.PLAN_TO_WATCH -> defaultPreferencesRepository.animePlannedListStyle
        ListStatusDto.PLAN_TO_READ -> defaultPreferencesRepository.mangaPlannedListStyle
        ListStatusDto.COMPLETED ->
            if (mediaType == MediaType.ANIME) defaultPreferencesRepository.animeCompletedListStyle
            else defaultPreferencesRepository.mangaCompletedListStyle

        ListStatusDto.ON_HOLD ->
            if (mediaType == MediaType.ANIME) defaultPreferencesRepository.animePausedListStyle
            else defaultPreferencesRepository.mangaPausedListStyle

        ListStatusDto.DROPPED ->
            if (mediaType == MediaType.ANIME) defaultPreferencesRepository.animeDroppedListStyle
            else defaultPreferencesRepository.mangaDroppedListStyle
        }
}
