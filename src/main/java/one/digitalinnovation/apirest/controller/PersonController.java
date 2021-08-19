package one.digitalinnovation.apirest.controller;

import one.digitalinnovation.apirest.dto.MessageResponseDTO;
import one.digitalinnovation.apirest.dto.request.PersonDTO;
import one.digitalinnovation.apirest.entity.Person;
import one.digitalinnovation.apirest.repository.PersonRepository;
import one.digitalinnovation.apirest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) {

        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody PersonDTO personDTO){

        return personService.updateById(id, personDTO);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteById( Long id){
        personService.delete(id);
}
}
