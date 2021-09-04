package ru.netology.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.repository.entity.Person;
import ru.netology.repository.entity.PersonKey;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, PersonKey> {
    List<Person> findPersonsByCityOfLiving(String city);

    List<Person> findPersonsByPersonKeyAgeLessThan(int age);

    Optional<Person> findPersonByPersonKeyNameAndPersonKeySurname(String name, String surname);
}
