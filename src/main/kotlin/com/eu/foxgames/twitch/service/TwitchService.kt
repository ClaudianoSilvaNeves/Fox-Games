package com.eu.foxgames.twitch.service

import com.eu.foxgames.dto.GameSearch
import com.eu.foxgames.service.JsonHandle
import com.eu.foxgames.twitch.config.TwitchUtil
import com.eu.foxgames.twitch.model.EndPoint
import com.eu.foxgames.twitch.model.GetInfFields
import com.eu.foxgames.twitch.model.Query
import org.springframework.stereotype.Service

/**
 * Service responsible for handling Twitch API queries.
 */
@Service
class TwitchService(
    private val twitchUtil: TwitchUtil,
) {

    /**
     * Searches for game information and saves the response as a JSON file
     * @param search DTO containing the game name for the search.
     * @return a json response,
     *
     * @see GetInfFields Defines the fields to be retrieved in the query.
     * @see JsonHandle Handles JSON processing.
     * @see JsonHandle.jsonToFile Saves the JSON response to a file.
     */
    fun getGamesInf(search: GameSearch): String {
        val fields = GetInfFields()
        val query = Query()
            .fields(fields.gameFields)
            .limit(500)
            .search(search.name)
            .queryBuilder()
        val json = twitchUtil.twitchGetGame(query, EndPoint.GAMES.url())
        JsonHandle().jsonToFile(json, "games")
        return json
    }

    /**
     * Converts a list of IDs into detailed information by querying the Twitch API.
     *
     * @param list List of IDs to be converted into game information.
     * @param endPoint The Twitch API endpoint to be used for retrieval.
     * @return A list of JSON responses containing detailed game information.
     */
    fun process(list: List<String>, endPoint: EndPoint): List<String> {
        return list.map { id -> twitchUtil.twitchGetGame(
                Query()
                    .fields("*")
                    .where(id)
                    .queryBuilder(), endPoint.url(),
            )
        }
    }
}
