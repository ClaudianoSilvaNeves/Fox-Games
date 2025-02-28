package com.eu.foxgames.model

import jakarta.persistence.*

@Entity
@Table(name = "tb_account_roles")
data class AccountRoles(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_roles_id")
    private var id: Long? = null,
    private var user_ID: Long? = null,
    private var role_ID: Long? = null,
)