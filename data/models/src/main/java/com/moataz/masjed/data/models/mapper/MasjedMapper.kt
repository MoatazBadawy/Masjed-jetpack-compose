package com.moataz.masjed.data.models.mapper

import com.moataz.masjed.data.models.GalleryModel
import com.moataz.masjed.data.models.MasjedDetailsModel
import com.moataz.masjed.data.models.MasjedModel
import com.moataz.masjed.domain.entities.Gallery
import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.entities.MasjedDetails

fun List<MasjedModel>.toMasjeds(): List<Masjed> {
    return map { it.toMasjed() }
}

fun MasjedModel.toMasjed(): Masjed {
    return Masjed(
        id = id,
        name = name,
        description = description,
        imgUrl = imgUrl,
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

fun MasjedDetailsModel.toMasjedDetails(): MasjedDetails {
    return MasjedDetails(
        id = id,
        masjedId = masjedId ?: 0,
        name = name ?: "",
        description = description ?: "",
        imgUrl = imgUrl ?: "",
        address = address ?: "",
        siteArea = siteArea ?: 0,
        minarets = minarets ?: 0,
        worshipers = worshipers ?: 0,
        imams = imams ?: 0,
        workers = workers ?: 0,
        gallery = gallery.toGalleries(),
    )
}

fun MasjedDetails.toMasjedDetailsModel(): MasjedDetailsModel {
    return MasjedDetailsModel(
        id = id,
        masjedId = masjedId,
        name = name,
        description = description,
        imgUrl = imgUrl,
        address = address,
        siteArea = siteArea,
        minarets = minarets,
        worshipers = worshipers,
        imams = imams,
        workers = workers,
        gallery = gallery.toGalleryModels(),
    )
}

fun List<Gallery>.toGalleryModels(): List<GalleryModel> {
    return map { it.toGalleryModel() }
}

fun Gallery.toGalleryModel(): GalleryModel {
    return GalleryModel(
        id = id,
        masjedId = masjedId,
        imgUrl = imgUrl,
    )
}

fun List<GalleryModel>.toGalleries(): List<Gallery> {
    return map { it.toGallery() }
}

fun GalleryModel.toGallery(): Gallery {
    return Gallery(
        id = id,
        masjedId = masjedId ?: 0,
        imgUrl = imgUrl ?: "",
    )
}
