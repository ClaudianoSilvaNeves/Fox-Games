package com.eu.foxgames.twitch.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

/**
 * Entity representing an authentication token for Twitch API.
 *
 * This token is used for authentication in API requests and has an expiration time.
 *
 * @property id Unique identifier of the token (auto-generated).
 * @property token The authentication token string.
 * @property expiresIn Duration in seconds until the token expires.
 * @property type Token type (e.g., "Bearer").
 * @property expiresAt The exact timestamp when the token expires.
 */
@Entity
data class Token(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val token: String,
    val expiresIn: Long,
    val type: String,
    val expiresAt: LocalDateTime = LocalDateTime.now()
) {
    /**
     * Calculates the expiration timestamp based on `expiresIn`.
     */
    fun expiresAt(): LocalDateTime {
        return expiresAt.plusSeconds(expiresIn)
    }
}