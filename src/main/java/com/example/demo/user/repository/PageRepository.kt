package com.example.demo.user.repository

import com.example.demo.user.model.entity.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface PageRepository : JpaRepository<Page, Long>, JpaSpecificationExecutor<Page> {

    fun findBySlotIdAndPath(slotId: String, path: String): Page

    fun existsBySlotIdAndPath(slotId: String, path: String): Boolean

}