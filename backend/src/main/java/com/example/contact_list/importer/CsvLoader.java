// CsvLoader.java
package com.example.contact_list.importer;

import com.example.contact_list.entity.Person;
import com.example.contact_list.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CsvLoader {

    private final PersonRepository personRepository;

    public CsvLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void loadCsv() throws Exception {
        var resource = new ClassPathResource("people.csv");

        try (var reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {

            // skip header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {

                String[] columns = line.split(",", 2); // name,imageUrl
                if (columns.length < 2) {
                    continue;
                }
                String name = columns[0].trim();
                String imageUrl = columns[1].trim();

                Person person = new Person(name, imageUrl);
                personRepository.save(person);
            }
        }
    }
}
