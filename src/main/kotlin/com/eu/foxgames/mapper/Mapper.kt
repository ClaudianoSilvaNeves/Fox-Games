package com.eu.foxgames.mapper

/**
 * Interface mapper
 *
 * convert one type to another type
 */
interface Mapper<U, T> {
    fun map(u: U): T
}