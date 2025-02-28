package com.eu.foxgames.controller

import com.eu.foxgames.dto.GameSearch
import com.eu.foxgames.dto.LoginDTO
import com.eu.foxgames.model.Game
import com.eu.foxgames.service.GameService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

/**
 * Class that controls all Fox Games endpoints
 */
@RestController
@RequestMapping("/foxgames")
class GameStoreController(
    private val service: GameService
) {
    /**
     * @param pageable use to show a pageable list of games.
     */
    @GetMapping
    fun showGames(pageable: Pageable): Page<Game> {
        return service.showGames(pageable)
    }

    /**
     * @param search is a DTO used to search Game by name.
     */
    @PostMapping
    @Transactional
    fun search(@RequestBody search: GameSearch): String {
        return service.search(search)
    }

    /**
     * Endpoint without Authentication,
     * Used only for a test
     */
    @PostMapping("/login")
    fun login(@RequestBody loginDTO: LoginDTO): ResponseEntity<Map<String, Any>> {
        val response = mapOf("message" to "Login bem-sucedido", "status" to "success")
        print("${loginDTO.email} \n {${loginDTO.password}}")
        return ResponseEntity.ok(response)
    }

    /**
     * Save Game Object in disk and persist on database.
     */
    @PostMapping("/save")
    fun save() {
        service.save()
    }

    /**
     * Used to update in repository
     */
    @PutMapping
    fun update(@RequestBody search: GameSearch) {
        service.update(search)
    }

    /**
     * Used to delete from repository
     * @param id used to select index to delete
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}
