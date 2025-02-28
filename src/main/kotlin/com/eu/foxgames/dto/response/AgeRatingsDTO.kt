package com.eu.foxgames.dto.response

/**
 * Data transfer object (DTO) representing the information received from Twitch API.
 *
 * This class is used to transfer the AgeRatings response information
 * from the API responses to the application logic
 */
data class AgeRatingsDTO(
    var id: String,
    var category: String,
    var content_descriptions: List<String>,
    var rating: String,
    var checksum: String,
    var organization: String,
    var rating_category: String,
    var rating_content_descriptions: List<String>
)
