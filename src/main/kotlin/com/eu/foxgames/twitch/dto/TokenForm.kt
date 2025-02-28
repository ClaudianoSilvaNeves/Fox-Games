package com.eu.foxgames.twitch.dto

/**
 * Data transfer object (DTO) representing the token information received from Twitch.
 *
 * This class is used to transfer the token information (such as access token, expiration time, and token type)
 * from the API responses to the application logic. It provides getter methods to access the token details.
 *
 * @param access_token The access token received from the Twitch API.
 * @param expires_in The expiration time of the token in seconds.
 * @param token_type The type of the token (e.g., Bearer).
 * @constructor Initializes the `TokenForm` with the given values.
 */
data class TokenForm(
    private val access_token: String,
    private val expires_in: Long,
    private val token_type: String,
) {
    /**
     * Returns the access token.
     *
     * @return The access token received from the Twitch API.
     */
    fun token(): String {
        return this.access_token
    }

    /**
     * Returns the expiration time of the token in seconds.
     *
     * @return The expiration time in seconds.
     */
    fun expireIn(): Long {
        return this.expires_in
    }

    /**
     * Returns the type of the token (e.g., Bearer).
     *
     * @return The token type.
     */
    fun type(): String {
        return this.token_type
    }
}
