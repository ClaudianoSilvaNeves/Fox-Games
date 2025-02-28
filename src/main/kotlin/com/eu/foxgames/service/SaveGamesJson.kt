package com.eu.foxgames.service

import com.eu.foxgames.model.Game
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Class convert game object to a file.
 *
 * @param jsonHandle class handle a json
 */
@Component
class SaveGamesJson(
    private val jsonHandle: JsonHandle
) {

    /**
     * Converts GameObject to a json file.
     *
     * @param games list of Game to convert into a file.
     *  Verify if the Games and the GameName folder exists, otherwise this folder will be created.
     * @see jsonHandle converts the game to file and save
     */
    fun toJson(games: List<Game>) {
        var success: Boolean = false
        while (true) {
            if (verifyDir("games")) {
                for (game in games) {
                    val gameName = game.name
                        .replace(Regex("[^A-Za-z0-9 ]"), "")
                    while (true) {
                        var gameDirectory = "games/$gameName/"
                        if (verifyDir(gameDirectory)) {
                            jsonHandle.gameToJson(game, "$gameDirectory$gameName")
                            success = true
                            break
                        } else {
                            createDir(gameDirectory)
                        }
                    }
                }
            } else {
                createDir("games")
            }
            if (success) break
        }
    }

    /**
     * Verifies if the folder exists.
     *
     * @param path path is the name of the one to be checked.
     * @Return boolean value
     */
    private fun verifyDir(path: String): Boolean {
        return Files.exists(Paths.get(path))
    }

    /**
     * Verifies if the folder exists.
     *
     * @param path path is the name of the folder to be created.
     */
    private fun createDir(path: String) {
        Files.createDirectories(Paths.get(path))
    }
}
