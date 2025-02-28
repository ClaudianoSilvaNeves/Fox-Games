package com.eu.foxgames.twitch.model

/**
 * Enum representing sorting order for queries.
 *
 * Used to define the order in which results should be retrieved from the API.
 *
 * @param apiName The corresponding value used in API requests.
 */
enum class Sort(val apiName: String) {
    /** Ascending order (A-Z, 0-9). */
    ASCENDING("asc"),
    /** Descending order (Z-A, 9-0). */
    DESCENDING("desc")
}