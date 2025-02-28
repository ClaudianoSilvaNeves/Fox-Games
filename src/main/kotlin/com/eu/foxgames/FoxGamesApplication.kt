package com.eu.foxgames

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class FoxGamesApplication

/**
 * Main application class for the FoxGames project.
 *
 * This application integrates with the IGDB API to retrieve and store game data.
 * Users can search for games by name, and the API returns multiple matching titles.
 */
fun main(args: Array<String>) {
	runApplication<FoxGamesApplication>(*args)
}
