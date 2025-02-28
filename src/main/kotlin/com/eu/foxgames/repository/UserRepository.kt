package com.eu.foxgames.repository

import com.eu.foxgames.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository for managing FoxGames API.
 *
 * This interface provides database access to store and retrieve User
 * used for communicating with the FoxGames API.
 */
@Repository
interface UserRepository: JpaRepository<User, Long>
