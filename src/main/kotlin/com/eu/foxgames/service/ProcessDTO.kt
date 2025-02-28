package com.eu.foxgames.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.stereotype.Component

/**
 * Generic class that converts any type of response into a DTO of a specific type
 */
@Component
class ProcessDTO {
    private val gson: Gson = Gson()

    /**
     * Converts list of strings to a list dto.
     *
     * @param list contains a DTO response
     * @param clazz is the type of DTO the list of String will be converted to.
     *
     * @return list of a specific DTO
     */
    fun <T> process(list: List<String>, clazz: Class<T>): List<T> {
        var listDTO: MutableList<T> = mutableListOf()
        val type = TypeToken.getParameterized(List::class.java, clazz).type
        for (an in list) {
            val obj = gson.fromJson<List<T>>(an, type)
            listDTO.addAll(obj)
        }
        return listDTO
    }
}
