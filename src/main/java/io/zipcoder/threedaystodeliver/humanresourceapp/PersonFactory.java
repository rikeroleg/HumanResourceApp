package io.zipcoder.threedaystodeliver.humanresourceapp;

public class PersonFactory {

    //only makes Humans
    //constructor method

    public static Person createPerson(HrContactInfo hrContactInfo){
        Person person = new Person();

        PersonWarehouse.addPerson(person);

        return null;
    }


}
