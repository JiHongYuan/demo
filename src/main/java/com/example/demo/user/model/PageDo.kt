package com.example.demo.user.model

import jakarta.validation.constraints.NotEmpty

class PageDo {

    @NotEmpty
    var slotId: String = ""

    @NotEmpty
    var path: String = ""

    @NotEmpty
    var html: String = "";

}