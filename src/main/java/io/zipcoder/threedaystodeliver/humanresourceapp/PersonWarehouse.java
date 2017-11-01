package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.ArrayList;

public class PersonWarehouse {

    ArrayList<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public ArrayList<Person> getPersonByName(String name){
        return null;
    }

    public Person getPersonById(String id){
        return null;
    }

    public ArrayList<Person> getAllPeople() {
        return people;
    }

    public ArrayList<Person> getAllProspects() {
        return null;
    }

    public ArrayList<Person> getAllEmployees() {
        return null;
    }

    public ArrayList<Person> getAllFormerEmployees() {
        return null;
    }

}
