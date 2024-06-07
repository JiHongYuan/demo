package com.example.demo.user.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "t_user_page")
class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0L

    @Column(name = "slot_id")
    var slotId: String = "";

    @Column(name = "path")
    var path: String = "";

    @Column(name = "html")
    var html: String = "";

}