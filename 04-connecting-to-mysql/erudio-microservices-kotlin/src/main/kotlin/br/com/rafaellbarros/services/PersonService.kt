package br.com.rafaellbarros.services

import br.com.rafaellbarros.exceptions.ResourceNotFoundException
import br.com.rafaellbarros.model.dto.v1.PersonDTO
import br.com.rafaellbarros.model.dto.v2.PersonDTO as PersonDTOV2
import br.com.rafaellbarros.model.entity.Person
import br.com.rafaellbarros.model.mapper.DozerMapper
import br.com.rafaellbarros.model.mapper.custom.PersonMapper
import br.com.rafaellbarros.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    private val logger = Logger.getLogger(PersonService::class.java.name)

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    fun findAll(): List<PersonDTO> {
        logger.info("Finding all people!")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonDTO::class.java)
    }

    fun findById(id: Long): PersonDTO {
        logger.info("Finding one person!")
        val person = getEntity(id)
        return DozerMapper.parseObject(person, PersonDTO::class.java)
    }

    fun create(person: PersonDTO) : PersonDTO {
        logger.info("Creating one person with name ${person.firstName}!")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonDTO::class.java)
    }

    fun createV2(person: PersonDTOV2) : PersonDTOV2 {
        logger.info("Creating one person with name ${person.firstName}!")
        val entity: Person = mapper.mapDTOToEntity(person)
        return mapper.mapEntityToDTO(repository.save(entity))
    }

    fun update(person: PersonDTO) : PersonDTO {
        logger.info("Updating one person with ID ${person.id}!")
        val entity = getEntity(person.id)

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return DozerMapper.parseObject(repository.save(entity), PersonDTO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id!")
        val entity = getEntity(id)
        repository.delete(entity)
    }

    private fun getEntity(id: Long): Person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
}