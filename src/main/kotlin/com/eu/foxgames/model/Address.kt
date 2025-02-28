package com.eu.foxgames.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_address")
data class Address(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private var id: Long? = null,
    private var city: String,
    private var street: String,
    private var number: Long? = null
) {
    fun getId(): Long? {
       return this.id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getCity(): String {
        return this.city
    }

    fun setCity(city: String) {
        this.city = city
    }

    fun getStreet(): String {
        return this.street
    }

    fun setStreet(street: String) {
        this.street = street
    }

    fun getNumber(): Long? {
        return this.number
    }

    fun setNumber(number: Long?) {
        this.number = number
    }
}