package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static io.zipcoder.threedaystodeliver.humanresourceapp.EmploymentStatus.PROSPECT;

public class PersonWarehouseTest {

    @Test
    public void addPersonTest() {
        PersonWarehouse personWarehouse = new PersonWarehouse();
        Person testPerson = new Person();
        personWarehouse.addPerson(testPerson);
        Assert.assertEquals(1, personWarehouse.getAllPeople().size());
    }

    @Test
    public void getPersonByNameTest() {
        PersonWarehouse personWarehouse = new PersonWarehouse();
        Person testPerson1 = new Person();
        Person testPerson2 = new Person();
        personWarehouse.addPerson(testPerson1);
        personWarehouse.addPerson(testPerson2);
        testPerson1.getContactInfo().setName("testName");
        testPerson2.getContactInfo().setName("testName");

        ArrayList<Person> testArrayList = new ArrayList<>(2);
        testArrayList.add(testPerson1);
        testArrayList.add(testPerson2);
        Assert.assertEquals(testArrayList, personWarehouse.getPersonByName("testName"));
    }

    @Test
    public void getPersonByIdTest(){
        PersonWarehouse personWarehouse = new PersonWarehouse();
        Person testPerson1 = new Person();
        personWarehouse.addPerson(testPerson1);
        testPerson1.setId("4815162342");
        Assert.assertEquals(testPerson1, personWarehouse.getPersonById("4815162342"));


    }

    @Test
    public void getAllProspects(){
        PersonWarehouse personWarehouse = new PersonWarehouse();
        ArrayList<Person> testProspects = new ArrayList<>(25);
        for(Person person: testProspects) {
            person.setEmploymentStatus(PROSPECT);
            personWarehouse.addPerson(person);
        }

        ArrayList<Person> actualProspects = personWarehouse.getAllProspects();;

        //Assert.assertArrayEquals(testProspects, actualProspects);
        boolean check = true;
        for(Person person: testProspects){
            if(actualProspects.contains(person)) {}
            else{check = false;}
        }

        Assert.assertTrue(check);

    }
}
