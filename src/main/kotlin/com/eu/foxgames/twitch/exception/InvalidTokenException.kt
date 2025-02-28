package com.eu.foxgames.twitch.exception
/**
 * Custom exception thrown when an invalid token is encountered.
 *
 * This exception is used to signal that a provided token is invalid, and the application
 * should handle this case accordingly, often by prompting the user to provide a new token
 * or by initiating a token refresh process.
 *
 * @param message A description of the issue or reason the token is considered invalid.
 * @constructor Initializes a new instance of the `InvalidTokenException` with a specific message.
 */
class InvalidTokenException(message: String): RuntimeException(message)