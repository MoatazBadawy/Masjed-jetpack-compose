package com.moataz.masjed.ui.viewmodel.models.mapper

import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.ui.viewmodel.models.MasjedUI

fun List<Masjed>.toMasjeds(): List<MasjedUI> {
    return map { it.toMasjedUI() }
}

fun Masjed.toMasjedUI(): MasjedUI {
    return MasjedUI(
        id = id,
        name = name,
        description = description,
        imgUrl = imgUrl,
    )
}
