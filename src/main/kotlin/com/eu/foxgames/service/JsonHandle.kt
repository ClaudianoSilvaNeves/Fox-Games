package com.eu.foxgames.service

import com.eu.foxgames.dto.GameForm
import com.eu.foxgames.model.Game
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths

/**
 * JsonHandle Class which handles json, conversion, reading and writing
 */
@Component
class JsonHandle {
    private val gson: Gson = Gson()
        .newBuilder()
        .serializeNulls()
        .setPrettyPrinting()
        .create()

    /**
     * Reads the games.json file to get information about the searched game.
     *
     * Check if the file exists, if it exists read the file, and convert into a list GameForm.
     * @return List of GameForm
     */
    fun jsonRead(): List<GameForm> {
        if (Files.exists(Paths.get("games.json"))) {
            val listType = object : TypeToken<List<GameForm>>() {}.type
            val listGamesForm: List<GameForm> = gson.fromJson(
                File("games.json").readText(), listType
            )
            return listGamesForm
        } else return listOf()
    }

    /**
     * Converts a Json to a file and saves it.
     *
     * @param json Information to save.
     * @param path Name of the folder to save the file.
     */
    fun jsonToFile(json: String, path: String) {
        fileWriter(json, path)
    }

    /**
     * Converts a GameObject to a file and saves it.
     *
     * @param game is a GameObject that will be converted into json and will be saved.
     * @param folderName the name of folder that will be saved a game.json
     */
    fun gameToJson(game: Game, folderName: String) {
        val json = gson.toJson(game)
        fileWriter(json, folderName)
    }

    /**
     * Responsible for writing the local file
     *
     * @param json information to save.
     * @param path directory to save the file.
     */
    private fun fileWriter(json: String, path: String) {
        val fileWriter = FileWriter("$path.json")
        fileWriter.write(json)
        fileWriter.close()
    }
}
