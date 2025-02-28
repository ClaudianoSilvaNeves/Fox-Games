package com.eu.foxgames.repository

import com.eu.foxgames.model.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository for managing FoxGames API.
 *
 * This interface provides database access to store and retrieve Games
 * used for communicating with the FoxGames API.
 */
@Repository
interface GameRepository: JpaRepository<Game, Long> {

    fun findByName(name: String): Game
}
