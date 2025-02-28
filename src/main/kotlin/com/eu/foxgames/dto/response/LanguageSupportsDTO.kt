package com.eu.foxgames.dto.response

/**
 * Data transfer object (DTO) representing the information received from Twitch API.
 *
 * This class is used to transfer the LanguageSupports response information
 * from the API responses to the application logic
 */
data class LanguageSupportsDTO(
    var id: String,
    var game: String,
    var language: String,
    var language_support_type: String,
    var created_at: String,
    var updated_at: String,
    var checksum: String
)
