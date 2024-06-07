package com.example.demo.user.service

import com.example.demo.user.model.PageDo
import com.example.demo.user.model.SlotDo

interface MyPageService {

    fun checkSlotId(slotId: String): String

    fun checkSlotIdAndPath(slotId: String, path: String): Boolean

    fun getIndexPageBySlotId(slotId: String): String

    fun getPathPageBySlotId(slotId: String, path: String): String

    fun add(slotDo: SlotDo)

    fun add(pageDo: PageDo)

}