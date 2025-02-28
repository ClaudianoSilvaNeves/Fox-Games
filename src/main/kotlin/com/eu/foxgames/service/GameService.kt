package com.eu.foxgames.service

import com.eu.foxgames.dto.GameForm
import com.eu.foxgames.dto.GameSearch
import com.eu.foxgames.mapper.GameMapper
import com.eu.foxgames.model.Game
import com.eu.foxgames.model.GameConverted
import com.eu.foxgames.repository.GameRepository
import com.eu.foxgames.twitch.service.TwitchService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Service responsible for handling FoxGames API.
 */
@Service
class GameService(
    private val repository: GameRepository,
    private val service: TwitchService,
    private val convertId: ConvertId,
    private val gameMapper: GameMapper,
    private val saveGamesJson: SaveGamesJson
) {

    /**
     * Show list of games.
     *
     * @return pageable list
     */
    fun showGames(pageable: Pageable): Page<Game> {
        return repository.findAll(pageable)
    }

    /**
     * Search Game from Twitch API
     *
     * @param search is a DTO that contains the name of the game to be searched.
     * @return json response.
     */
    fun search(search: GameSearch): String {
        return service.getGamesInf(search)
    }

    /**
     * Responsible for saving and persisting a game in the Database.
     */
    fun save() {
        val listGameForm = JsonHandle().jsonRead()
        var listGameConverted: MutableList<GameConverted> = mutableListOf()
        for (gf: GameForm in listGameForm) {
            val converted = convertId.convert(gf)
            listGameConverted.add(converted)
        }
        val games = listGameConverted.map {
            gc -> gameMapper.map(gc)
        }.toList()
        saveGamesJson.toJson(games)
        games.forEach { g -> repository.save(g)}

    }

    /**
     * Update game.
     *
     * @param search used to find object in Repository.
     */
    fun update(search: GameSearch) {
        repository.findByName(search.name)
    }

    /**
     * Delete by id
     *
     * @param id used to select the index to be deleted from the Repository.
     */
    fun delete(id: Long) {
        repository.deleteById(id)
    }
}
