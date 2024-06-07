package com.example.demo.blog.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "t_blog_category")
class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0L

    @Column(name = "user_id")
    var userId: Long = 0L

    @Column(name = "parent_id")
    var parentId: Long = 0L;

    @Column(name = "category_name")
    var name: String = ""

    @Column(name = "sort")
    var sort: Int = Int.MAX_VALUE;

}