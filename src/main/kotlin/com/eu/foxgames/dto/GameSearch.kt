package com.eu.foxgames.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

/**
 * GameSearch DTO Used to take the response body and perform the search.
 *
 * @property name get a game name from body.
 */
data class GameSearch(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    var name: String
)
