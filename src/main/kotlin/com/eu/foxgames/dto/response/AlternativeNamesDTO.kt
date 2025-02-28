package com.eu.foxgames.dto.response

/**
 * Data transfer object (DTO) representing the information received from Twitch API.
 *
 * This class is used to transfer the AlternativeNames response information
 * from the API responses to the application logic
 */
data class AlternativeNamesDTO(
    var id: String,
    var comment: String,
    var game: String,
    var name: String,
    var checksum: String
)
