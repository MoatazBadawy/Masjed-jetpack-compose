package com.moataz.masjed.ui.viewmodel.models.mapper

import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.ui.viewmodel.models.MasjedUI

fun List<Masjed>.toMasjeds(): List<MasjedUI> {
    return map { it.toMasjedUI() }
}

fun Masjed.toMasjedUI(): MasjedUI {
    return MasjedUI(
        masjedId = masjedId,
        masjedName = masjedName,
        masjedDescription = masjedDescription,
        masjedImg = masjedImg,
        masjedWorshipers = masjedWorshipers,
        masjedImams = masjedImams,
        masjedWorkers = masjedWorkers,
    )
}

fun MasjedUI.toMasjed(): Masjed {
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
