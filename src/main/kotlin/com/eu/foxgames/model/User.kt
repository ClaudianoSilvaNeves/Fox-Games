package com.eu.foxgames.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private var id: Long? = null,
    @Column(unique = true)
    private var name: String,
    private var email: String,
    @JsonIgnore
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "account_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")])
    private var roles: List<Role> = mutableListOf()
    ){
    fun getId(): Long? {
        return this.id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getName(): String {
        return this.email
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getEmail(): String {
        return this.email
    }

    fun setEmail(email: String) {
        this.email = email
    }
}
