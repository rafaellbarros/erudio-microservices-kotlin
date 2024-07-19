package br.com.rafaellbarros.model.mapper.custom

import br.com.rafaellbarros.model.dto.v2.PersonDTO
import br.com.rafaellbarros.model.entity.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToDTO(person: Person): PersonDTO {
        val vo = PersonDTO()
        vo.id = person.id
        vo.address = person.address
        vo.birthDay = Date()
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.gender = person.gender
        return vo
    }

    fun mapDTOToEntity(person: PersonDTO): Person {
        val entity = Person()
        entity.id = person.id
        entity.address = person.address
        // entity.birthDay = person.birthDay
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.gender = person.gender
        return entity
    }
}