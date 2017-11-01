package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.ArrayList;

public class PersonWarehouse {

    ArrayList<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public ArrayList<Person> getPersonByName(String name){
        ArrayList<Person> listOfMatchedNames = new ArrayList<>(10);
        for(Person person: people) {
            if(person.getContactInfo().getName().equals(name)) {
                listOfMatchedNames.add(person);
            }
        }
        return listOfMatchedNames;
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
