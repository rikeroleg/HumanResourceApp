package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
}
