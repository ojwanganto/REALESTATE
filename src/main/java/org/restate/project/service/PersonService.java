package org.restate.project.service;

import org.restate.project.model.Person;

import java.util.List;

/**
 * service class for Person class
 */
public interface PersonService {

    public Person savePerson(Person person);
    public Person getPersonById(Integer pid);
    public List<Person> getPersonsList();

}
