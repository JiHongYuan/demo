package com.example.demo.blog.repository

import com.example.demo.blog.model.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
}