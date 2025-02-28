package com.eu.foxgames.twitch.model

/**
 * Enum class representing different API endpoints for querying game-related data from Twitch.
 *
 * Each value in this enum corresponds to a specific endpoint in the Twitch API that deals with
 * different aspects of game data, such as game ratings, covers, platforms, genres, and much more.
 * The `url()` function converts the enum constant into its lowercase string representation, which
 * can be used to build a URL for making API requests.
 */
enum class EndPoint {
    AGE_RATINGS, AGE_RATING_CONTENT_DESCRIPTIONS, ALTERNATIVE_NAMES, ARTWORKS, CHARACTERS, CHARACTER_MUG_SHOTS,
    COLLECTIONS, COMPANIES, COMPANY_WEBSITES, COMPANY_LOGOS, COVERS, EXTERNAL_GAMES, FRANCHISES, GAMES, GAME_ENGINES,
    GAME_ENGINE_LOGOS, GAME_LOCALIZATIONS, GAME_MODES, GAME_VERSIONS, GAME_VERSION_FEATURES, GAME_VERSION_FEATURE_VALUES, GAME_VIDEOS,
    GENRES, INVOLVED_COMPANIES, KEYWORDS, LANGUAGES, LANGUAGE_SUPPORTS, LANGUAGE_SUPPORT_TYPES, MULTIPLAYER_MODES,
    PLATFORMS, PLATFORM_LOGOS, PLATFORM_VERSIONS, PLATFORM_VERSION_COMPANIES, PLATFORM_VERSION_RELEASE_DATES,
    PLATFORM_WEBSITES, PLAYER_PERSPECTIVES, PLATFORM_FAMILIES, REGIONS, RELEASE_DATES, SCREENSHOTS, SEARCH, THEMES,
    WEBSITES, EVENTS, EVENT_LOGOS, EVENT_NETWORKS, NETWORK_TYPES, COLLECTION_RELATIONS, COLLECTION_RELATION_TYPES,
    COLLECTION_TYPES, COLLECTION_MEMBERSHIPS, COLLECTION_MEMBERSHIP_TYPES, POPULARITY_TYPES, POPULARITY_PRIMITIVES;

    /**
     * Converts the enum constant name to its lowercase string representation.
     * This string is used to create the URL for making API requests to Twitch.
     *
     * @return The endpoint URL as a lowercase string.
     */
    fun url(): String {
        return this.name.lowercase()
    }
}