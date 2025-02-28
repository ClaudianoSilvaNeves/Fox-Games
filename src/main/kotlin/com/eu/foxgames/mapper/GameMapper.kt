package com.eu.foxgames.mapper

import com.eu.foxgames.model.Game
import com.eu.foxgames.model.GameConverted
import org.springframework.stereotype.Component

/**
 * GameMapper that class convert GameConverted into a Game object.
 */
@Component
class GameMapper: Mapper<GameConverted, Game> {
    /**
     * Map function of mapper interface
     *
     * @param gameConverted is a gameForm with selected and converted information, contains the list of specific types of DTOs.
     * Select only the necessary information for each DTO type from the specified list.
     * @Return Game object
     */
    override fun map(gameConverted: GameConverted): Game {
        return Game(
            name = gameConverted.name,
            alternativeNames = gameConverted.alternative_names.map { an -> an.name },
            category =  gameConverted.category,
            genres = gameConverted.genres.map { gr -> gr.name},
            languageSupports = gameConverted.language_supports.map { ls -> ls.language },
            artworks = gameConverted.artworks.map { aw -> aw.url },
            ageRatings = gameConverted.age_ratings.map { ar -> ar.rating },
            websites = gameConverted.websites.map { ws -> ws.url }
        )
    }
}
