package com.eu.foxgames.twitch.model

/**
 * Data class that holds the fields for a game query.
 *
 * This class is used to define a list of fields that can be requested from the Twitch API.
 * The list contains various attributes related to a game, such as ratings, platforms, release dates, and more.
 * The `gameFields` property contains a comma-separated string of these fields, which can be used in queries
 * to specify which data should be returned by the API.
 *
 * @property gameFields A comma-separated list of fields representing various attributes of a game, such as
 * age ratings, genres, release dates, and more. This list is used to filter the data returned by the API.
 */
data class GetInfFields(
    val gameFields: String = "age_ratings,aggregated_rating,aggregated_rating_count,alternative_names,artworks,bundles,category,checksum,collection,collections,cover,created_at,dlcs,expanded_games,expansions,external_games,first_release_date,follows,forks,franchise,franchises,game_engines,game_localizations,game_modes,genres,hypes,involved_companies,keywords,language_supports,multiplayer_modes,name,parent_game,platforms,player_perspectives,ports,rating,rating_count,release_dates,remakes,remasters,screenshots,similar_games,slug,standalone_expansions,status,storyline,summary,tags,themes,total_rating,total_rating_count,updated_at,url,version_parent,version_title,videos,websites",
)