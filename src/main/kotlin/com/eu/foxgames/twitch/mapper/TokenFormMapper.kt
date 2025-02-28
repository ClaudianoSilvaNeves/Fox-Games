package com.eu.foxgames.twitch.mapper


import com.eu.foxgames.mapper.Mapper
import com.eu.foxgames.twitch.dto.TokenForm
import com.eu.foxgames.twitch.model.Token
import org.springframework.stereotype.Component

/**
 * A component that maps a `TokenForm` DTO to a `Token` entity.
 *
 * This class implements the `Mapper` interface to transform data from the `TokenForm` object
 * into a `Token` entity. The `TokenFormMapper` is used to convert the input form data into a model
 * that can be saved to the database or used in the application logic.
 *
 * @constructor Initializes a new instance of the `TokenFormMapper` class.
 */
@Component
class TokenFormMapper: Mapper<TokenForm, Token> {

    /**
     * Maps a `TokenForm` DTO to a `Token` entity.
     *
     * This function takes a `TokenForm` object as input and converts it into a `Token` entity,
     * extracting values for the token, expiration time, and type.
     *
     * @param form The `TokenForm` DTO that contains the data to be mapped.
     * @return A `Token` entity that corresponds to the provided `TokenForm`.
     */
    override fun map(form: TokenForm): Token {
        return Token(
            token = form.token(),
            expiresIn = form.expireIn(),
            type = form.type()
        )
    }
}