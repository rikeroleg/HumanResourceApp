package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersonWarehouse {

    private static final PersonWarehouse INSTANCE = null;

    private static ArrayList<Person> people = new ArrayList<>();

    private PersonWarehouse(){}

    public static PersonWarehouse getInstance(){
        if(INSTANCE == null){
            return new PersonWarehouse();
        } else {
            return INSTANCE;
        }
    }

    public static void addPerson(Person person) {
        people.add(person);
    }

    public static ArrayList<Person> getPersonByName(String name){
        ArrayList<Person> listOfMatchedNames = new ArrayList<>(10);
        for(Person person: people) {
            if(person.getContactInfo().getName().equals(name)) {
                listOfMatchedNames.add(person);
            }
        }
        return listOfMatchedNames;
    }

    public static Person getPersonById(String id){
        for(Person person: people) {
            if(person.getId().equals(id)) return person;
        }

        return null;
    }

    public static ArrayList<Person> getAllPeople() {
        return people;
    }

    public  static ArrayList<Person> getAllProspects() {
        ArrayList<Person> listOfProspects = new ArrayList<>(100);
        for (Person person : people) {
            if (person.getEmploymentStatus().equals(EmploymentStatus.PROSPECT)) {
                listOfProspects.add(person);
            }
        }
        return listOfProspects;
    }


    public  static ArrayList<Person> getAllEmployees() {
        ArrayList<Person> listOfAllEmployees = new ArrayList<>(100);
        for (Person person : people) {
            if (person.getEmploymentStatus().equals(EmploymentStatus.EMPLOYEE)) {
                listOfAllEmployees.add(person);
            }
        }
        return listOfAllEmployees;
    }

    public static ArrayList<Person> getAllFormerEmployees() {
        ArrayList<Person> listOfFormerEmployees = new ArrayList<>(3);
        for (Person person : people) {
            if (person.getEmploymentStatus().equals(EmploymentStatus.TERMINATED)){
                listOfFormerEmployees.add(person);
            }
        }return listOfFormerEmployees;
    }

}
