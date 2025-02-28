package com.eu.foxgames.twitch.config

import com.eu.foxgames.twitch.dto.TokenForm
import com.eu.foxgames.twitch.mapper.TokenFormMapper
import com.eu.foxgames.twitch.model.Token
import com.eu.foxgames.twitch.repository.TwitchTokenRepository
import com.google.gson.Gson
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration
import java.time.LocalDateTime

/**
 * Utility class to interact with Twitch's IGDB API.
 * This class is responsible for handling the access token (obtaining and verifying it),
 * and for making requests to the IGDB API with proper headers.
 *
 * @param repository The repository used to manage and store the tokens in the database.
 * @param tokenFormMapper A mapper that converts a TokenForm to a Token object.
 */
@Component
class TwitchUtil(
    private val repository: TwitchTokenRepository,
    private val tokenFormMapper: TokenFormMapper
) {
    private val clientID = System.getenv("clientID")
    private val clientSecret = System.getenv("clientSecret")
    private val getTokenAddress = "https://id.twitch.tv/oauth2/token?client_id=$clientID&client_secret=$clientSecret&grant_type=client_credentials"
    private val getGameInf = "https://api.igdb.com/v4/"
    private lateinit var token: Token

    /**
     * Initializes the class by checking the database for a valid token.
     * If no token exists in the database, a new token is requested and saved.
     * If a valid token is found, it is loaded and verified.
     */
    @PostConstruct
    private fun init() {
        var loop = true
        while(loop) {
            if(repository.findAll().isEmpty()) {
                repository.save(requestToken())
            } else {
                this.token = repository.findAll()[0]
                isValid(token)
                loop = false
            }
        }
    }

    /**
     * Sends a POST request to the IGDB API with the provided query and endpoint.
     * The request includes the necessary headers, such as the authorization token and client ID.
     *
     * @param query The query to be sent in the request body.
     * @param endpoint The API endpoint to request data from.
     * @return The response body as a string.
     */
    fun twitchGetGame(query: String, endpoint: String): String {
        val client = HttpClient
            .newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build()
        val body = HttpRequest.BodyPublishers.ofString(query)
        val request = HttpRequest.newBuilder()
            .timeout(Duration.ofSeconds(5))
            .uri(URI.create(getGameInf + endpoint))
            .header("Content-Type", "application/json")
            .header("Client-ID", clientID)
            .header("Authorization", "bearer " + token.token)
            .POST(body)
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }

    /**
     * Requests a new access token from Twitch.
     * This function sends a POST request to the Twitch OAuth2 token endpoint to retrieve a new token.
     *
     * @return A Token object representing the new access token.
     */
    private fun requestToken(): Token {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.noBody())
            .uri(URI.create(getTokenAddress))
            .build()
        val response: HttpResponse<String> = client.send(request, HttpResponse.BodyHandlers.ofString())
        return jsonToToken(response.body())
    }

    /**
     * Converts a JSON string into a Token object.
     *
     * @param json The JSON string to be converted.
     * @return A Token object containing the access token data.
     */
    private fun jsonToToken(json: String): Token {
        val tokenForm = Gson().fromJson(json, TokenForm::class.java)
        return tokenFormMapper.map(tokenForm)
    }

    /**
     * Verifies if the token is expired or if the type is invalid.
     * If the token is expired or not of the "bearer" type, it deletes the old token from the database.
     *
     * @param token The Token object to be verified.
     */
    private fun isValid(token: Token) {
        if (token.expiresAt().isBefore(LocalDateTime.now()) || token.type != "bearer") {
            repository.deleteById(0)
        }
    }
}
