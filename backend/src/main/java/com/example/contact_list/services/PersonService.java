package com.example.contact_list.services;

import com.example.contact_list.dto.PersonListDto;
import com.example.contact_list.entity.Person;
import com.example.contact_list.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonListDto> listPeople() {
        return personRepository.findAll()
                .stream()
                .map(person -> new PersonListDto(
                        person.getName(),
                        person.getImageUrl()
                ))
                .toList();
    }
    public Optional<Person> getPersonByName(String name) {
        return personRepository.findByName(name);
    }
    public List<Person> searchPeopleByPartiallyMatchedName(String keyword) {
        return personRepository.findByNameContainingIgnoreCase(keyword);
    }
}