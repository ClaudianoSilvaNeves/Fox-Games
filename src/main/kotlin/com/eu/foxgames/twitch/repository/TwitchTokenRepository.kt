package com.eu.foxgames.twitch.repository

import com.eu.foxgames.twitch.model.Token
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository for managing Twitch API tokens.
 *
 * This interface provides database access to store and retrieve authentication tokens
 * used for communicating with the Twitch API.
 */
@Repository
interface TwitchTokenRepository: JpaRepository<Token, Long>
