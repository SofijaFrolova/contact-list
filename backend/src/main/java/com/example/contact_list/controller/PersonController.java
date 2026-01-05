package com.example.contact_list.controller;

import com.example.contact_list.dto.PersonListDto;
import com.example.contact_list.repository.PersonRepository;
import com.example.contact_list.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class PersonController {
    private final PersonRepository personRepository;
    private PersonService personService;

    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @GetMapping("/api/people")
    public List<PersonListDto> getPeople() {
        return personService.listPeople();
    }
}