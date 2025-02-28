package com.eu.foxgames.twitch.exception

import org.springframework.cache.annotation.CacheEvict
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * Global exception handler for handling specific exceptions across all controllers.
 *
 * This class is annotated with `@RestControllerAdvice` and serves as a centralized place to handle
 * exceptions thrown in the application. It specifically handles `InvalidTokenException` and performs
 * necessary actions such as cache eviction when such an exception is encountered.
 */
@RestControllerAdvice
class ExceptionHandler {

    /**
     * Handles the `InvalidTokenException` and evicts the cached token data.
     *
     * When an `InvalidTokenException` is thrown, this method is triggered. It clears the cached
     * token data (labeled as `timetoken` in this case), which might be invalid, to ensure that
     * subsequent requests are made with fresh token data.
     *
     * @param e The `InvalidTokenException` that was thrown.
     */
    @ExceptionHandler(InvalidTokenException::class)
    @CacheEvict("timetoken")
    fun expired(
        e: InvalidTokenException
    ) {
        // No additional actions required here, as cache eviction is handled by @CacheEvict
    }
}