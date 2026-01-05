package com.example.contact_list.repository;

import com.example.contact_list.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
    List<Person> findByNameContainingIgnoreCase(String name);
}