package com.eu.foxgames.model

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "tb_game")
data class Game(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(unique = true)
    var name: String,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    val alternativeNames: List<String>,
    val category: String,
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    val genres: List<String>,
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    val languageSupports: List<String>,
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    val artworks: List<String>,
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    val ageRatings: List<String>,
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    val websites: List<String>
)