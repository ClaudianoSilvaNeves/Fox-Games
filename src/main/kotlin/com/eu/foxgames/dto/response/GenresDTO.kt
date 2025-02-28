package com.eu.foxgames.dto.response

/**
 * Data transfer object (DTO) representing the information received from Twitch API.
 *
 * This class is used to transfer the Genres response information
 * from the API responses to the application logic
 */
data class GenresDTO(
    var id: String,
    var created_at: String,
    var name: String,
    var slug: String,
    var updated_at: String,
    var url: String,
    var checksum: String
)