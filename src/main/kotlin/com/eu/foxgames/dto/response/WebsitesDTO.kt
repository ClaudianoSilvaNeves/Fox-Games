package com.eu.foxgames.dto.response

/**
 * Data transfer object (DTO) representing the information received from Twitch API.
 *
 * This class is used to transfer the Websites response information
 * from the API responses to the application logic
 */
data class WebsitesDTO(
    var id: String,
    var category: String,
    var game: String,
    var trusted: String,
    var url: String,
    var checksum: String,
    var type: String,
)
