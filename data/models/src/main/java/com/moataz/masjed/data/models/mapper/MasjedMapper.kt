package com.moataz.masjed.data.models.mapper

import com.moataz.masjed.data.models.MasjedModel
import com.moataz.masjed.domain.entities.Masjed

fun List<MasjedModel>.toMasjeds(): List<Masjed> {
    return map { it.toMasjed() }
}

fun MasjedModel.toMasjed(): Masjed {
    return Masjed(
        id = id ?: 0,
        name = name ?: "",
        description = description ?: "",
        imgUrl = imgUrl ?: "",
    )
}

fun Masjed.toMasjedModel(): MasjedModel {
    return MasjedModel(
        id = id,
        name = name,
        description = description,
        imgUrl = imgUrl,
    )
}
