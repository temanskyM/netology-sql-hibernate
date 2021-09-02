package ru.netology.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.repository.entity.Person;
import ru.netology.repository.entity.PersonKey;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PersonRepository {
    private static final String getPersonsByCityQuery = "SELECT p FROM Person p where p.cityOfLiving = :city";
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery(getPersonsByCityQuery, Person.class)
                .setParameter("city", city)
                .getResultList();
    }
    @Transactional
    public void insert(Person person){
        entityManager.persist(person);
    }
}
