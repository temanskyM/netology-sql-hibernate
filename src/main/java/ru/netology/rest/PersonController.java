package ru.netology.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.repository.PersonRepository;
import ru.netology.repository.entity.Person;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/api/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.getPersonsByCity(city);
    }

    @PostMapping("/api/persons/")
    public void getPersonsByCity(@RequestBody Person person) {
        personRepository.insert(person);
    }
}
