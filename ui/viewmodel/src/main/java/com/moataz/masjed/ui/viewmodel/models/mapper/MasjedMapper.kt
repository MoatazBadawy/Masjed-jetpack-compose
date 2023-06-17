package com.moataz.masjed.ui.viewmodel.models.mapper

import com.moataz.masjed.domain.entities.Gallery
import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.entities.MasjedDetails
import com.moataz.masjed.ui.viewmodel.models.GalleryUI
import com.moataz.masjed.ui.viewmodel.models.MasjedDetailsUI
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

fun MasjedDetails.toMasjedDetailsUI(): MasjedDetailsUI {
    return MasjedDetailsUI(
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
        gallery = gallery.map { it.toGalleryUI() }
    )
}

fun Gallery.toGalleryUI(): GalleryUI {
    return GalleryUI(
        id = id,
        masjedId = masjedId,
        imgUrl = imgUrl,
    )
}
