package br.com.rafaellbarros.model.dto.v2

import java.util.Date

data class PersonDTO (
        var id: Long = 0,
        var firstName: String = "",
        var lastName: String = "",
        var address: String = "",
        var gender: String = "",
        var birthDay: Date? = null
)