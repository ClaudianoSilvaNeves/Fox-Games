package com.eu.foxgames.model

import com.eu.foxgames.dto.response.*

data class GameConverted(
    var name: String,
    val alternative_names: List<AlternativeNamesDTO>,
    val category: String,
    val genres: List<GenresDTO>,
    val language_supports: List<LanguageSupportsDTO>,
    val artworks: List<ArtworksDTO>,
    val age_ratings: List<AgeRatingsDTO>,
    val websites: List<WebsitesDTO>
)