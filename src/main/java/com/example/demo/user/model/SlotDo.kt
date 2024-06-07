package com.example.demo.user.model

import jakarta.validation.constraints.NotEmpty

class SlotDo {

    @NotEmpty
    var uuid: String = ""

}