package com.example.demo.user.repository

import com.example.demo.user.model.entity.Slot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface SlotRepository : JpaRepository<Slot, String>, JpaSpecificationExecutor<Slot> {

}