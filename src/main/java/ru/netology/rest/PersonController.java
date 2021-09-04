package ru.netology.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.repository.PersonRepository;
import ru.netology.repository.entity.Person;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/api/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findPersonsByCityOfLiving(city);
    }

    @GetMapping("/api/persons/by-age")
    public List<Person> findPersonsAgeLessThan(@RequestParam int age) {
        return personRepository.findPersonsByPersonKeyAgeLessThan(age);
    }

    @GetMapping("/api/persons/by-name-surname")
    public ResponseEntity<Person> findPersonByPersonKeyNameAndPersonKeySurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Person> person = personRepository.findPersonByPersonKeyNameAndPersonKeySurname(name, surname);
        return ResponseEntity.of(person);
    }

    @PostMapping("/api/persons/")
    public void getPersonsByCity(@RequestBody Person person) {
        personRepository.save(person);
    }
}
