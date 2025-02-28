package com.eu.foxgames.service

import com.eu.foxgames.dto.GameForm
import com.eu.foxgames.dto.response.*
import com.eu.foxgames.model.GameConverted
import com.eu.foxgames.twitch.model.EndPoint
import com.eu.foxgames.twitch.service.TwitchService
import org.springframework.stereotype.Component

/**
 * This class converts ids into a list of DTOs and creates a GameConverted with useful information.
 */
@Component
class ConvertId(
    private val twitchService: TwitchService,
    private val processDTO: ProcessDTO
) {

    /**
     * Convert GameForm into a GameConverted
     * @see process to get useful information in the specified endpoint
     */
    fun convert(gameForm: GameForm): GameConverted {
        print(gameForm.name)
        val alternativeNames = process(gameForm.alternative_names, EndPoint.ALTERNATIVE_NAMES)
        val genres = process(gameForm.genres, EndPoint.GENRES)
        val languageSupports = process(gameForm.language_supports, EndPoint.LANGUAGE_SUPPORTS)
        val artworks = process(gameForm.artworks, EndPoint.ARTWORKS)
        val ageRatings = process(gameForm.age_ratings, EndPoint.AGE_RATINGS)
        val websites = process(gameForm.websites, EndPoint.WEBSITES)

        /**
         * Converts all variables into list of DTOs to create a new GameConverted.
         * @return GameConverted object
         */
        return GameConverted(
            name = if (gameForm.name.isNullOrEmpty()) "" else gameForm.name,
            alternative_names = processDTO.process(alternativeNames, AlternativeNamesDTO::class.java),
            category = if (gameForm.category.isNullOrEmpty()) "" else gameForm.category,
            genres = processDTO.process(genres, GenresDTO::class.java),
            language_supports = processDTO.process(languageSupports, LanguageSupportsDTO::class.java),
            artworks = processDTO.process(artworks, ArtworksDTO::class.java),
            age_ratings = processDTO.process(ageRatings, AgeRatingsDTO::class.java),
            websites = processDTO.process(websites, WebsitesDTO::class.java)
        )
    }

    /**
     * Checks if the list is empty or null, if not it performs the conversion
     *
     * @param list contains IDs
     * @param endPoint controls where the information will be requested from
     * @return list of String containing useful information
     */
    private fun process(list: List<String>, endPoint: EndPoint): List<String> {
        return if (list.isNullOrEmpty()) {
            emptyList()
        } else {
            twitchService.process(list, endPoint)
        }
    }
}
