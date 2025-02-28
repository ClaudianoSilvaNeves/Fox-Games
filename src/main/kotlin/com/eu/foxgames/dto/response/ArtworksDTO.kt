package com.eu.foxgames.dto.response

/**
 * Data transfer object (DTO) representing the information received from Twitch API.
 *
 * This class is used to transfer the Artworks response information
 * from the API responses to the application logic
 */
data class ArtworksDTO(
    var id: String,
    var game: String,
    var height: String,
    var image_id: String,
    var url: String,
    var width: String,
    var checksum: String
)
