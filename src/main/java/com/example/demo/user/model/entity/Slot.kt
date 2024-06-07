package com.example.demo.user.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "t_user_slot")
class Slot {

    @Id
    @Column(name = "id")
    var id: String = ""

    @Column(name = "user_id")
    var userId: Long = 0L;

}