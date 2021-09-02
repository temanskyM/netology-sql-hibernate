package ru.netology.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Person {
    @EmbeddedId
    private PersonKey personKey;
    private String cityOfLiving;
    private String phoneNumber;
}
