package com.moataz.masjed.data.models.mapper

import com.moataz.masjed.data.models.MasjedModel
import com.moataz.masjed.domain.entities.Masjed

fun List<MasjedModel>.toMasjeds(): List<Masjed> {
    return map { it.toMasjed() }
}

fun MasjedModel.toMasjed(): Masjed {
    return Masjed(
        masjedId = masjedId,
        masjedName = masjedName,
        masjedDescription = masjedDescription,
        masjedImg = masjedImg,
        masjedWorshipers = masjedWorshipers,
        masjedImams = masjedImams,
        masjedWorkers = masjedWorkers,
    )
}

fun Masjed.toMasjedModel(): MasjedModel {
    return MasjedModel(
        masjedId = masjedId,
        masjedName = masjedName,
        masjedDescription = masjedDescription,
        masjedImg = masjedImg,
        masjedWorshipers = masjedWorshipers,
        masjedImams = masjedImams,
        masjedWorkers = masjedWorkers,
    )
}