package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

public class PersonWarehouseTest {

    @Test
    public void addPersonTest() {
        PersonWarehouse personWarehouse = new PersonWarehouse();
        Person testPerson = new Person();
        personWarehouse.addPerson(testPerson);
        Assert.assertEquals(1, personWarehouse.getAllPeople().size());
    }
}
