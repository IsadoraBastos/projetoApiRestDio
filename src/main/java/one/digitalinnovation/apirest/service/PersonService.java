package one.digitalinnovation.apirest.service;


import one.digitalinnovation.apirest.dto.MessageResponseDTO;
import one.digitalinnovation.apirest.dto.request.PersonDTO;
import one.digitalinnovation.apirest.entity.Person;
import one.digitalinnovation.apirest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

private PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person savedPerson = personRepository.save(personDTO);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();

    }
    public PersonDTO findById(Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);
    }

    public void delete(Long id) {
        personRepository.findById(id);

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) {
        Person savedPerson = personRepository.save(personToUpdate);
        return MessageResponseDTO
                .builder()
                .message("Update person with ID" + savedPerson.getId())
                .build();
    }
    }
}
