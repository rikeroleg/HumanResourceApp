package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static io.zipcoder.threedaystodeliver.humanresourceapp.EmploymentStatus.EMPLOYEE;
import static io.zipcoder.threedaystodeliver.humanresourceapp.EmploymentStatus.PROSPECT;
import static io.zipcoder.threedaystodeliver.humanresourceapp.EmploymentStatus.TERMINATED;

public class PersonWarehouseTest {


    @Before
    public void setUp(){
        PersonWarehouse.getInstance();
    }
    
    @Test
    public void addPersonTest() {
        Person testPerson = new Person();
        testPerson.setEmploymentStatus(EmploymentStatus.EMPLOYEE);
        int initialSize = PersonWarehouse.getAllPeople().size();
        PersonWarehouse.addPerson(testPerson);
        Assert.assertEquals(initialSize + 1, PersonWarehouse.getAllPeople().size());

    }

    @Test
    public void getPersonByNameTest() {
        Person testPerson1 = new Person();
        Person testPerson2 = new Person();
        PersonWarehouse.addPerson(testPerson1);
        PersonWarehouse.addPerson(testPerson2);
        testPerson1.setEmploymentStatus(EMPLOYEE);
        testPerson2.setEmploymentStatus(PROSPECT);
        testPerson1.getContactInfo().setName("testName");
        testPerson2.getContactInfo().setName("testName");

        ArrayList<Person> testArrayList = new ArrayList<>(2);
        testArrayList.add(testPerson1);
        testArrayList.add(testPerson2);

        Assert.assertArrayEquals(testArrayList.toArray(), PersonWarehouse.getPersonByName("testName").toArray());
    }

    @Test
    public void getPersonByIdTest(){
        Person testPerson1 = new Person();
        testPerson1.setEmploymentStatus(TERMINATED);
        PersonWarehouse.addPerson(testPerson1);
        testPerson1.setId("4815162342");
        Assert.assertEquals(testPerson1, PersonWarehouse.getPersonById("4815162342"));


    }

    @Test
    public void getAllProspects(){
        int inititalAllProspectsCount = PersonWarehouse.getAllProspects().size();

        for(int i =0; i < 5; i++){
            Person testPerson = new Person();
            testPerson.setEmploymentStatus(PROSPECT);
            PersonWarehouse.addPerson(testPerson);
        }

        Assert.assertEquals(inititalAllProspectsCount+5, PersonWarehouse.getAllProspects().size());

    }

    @Test
    public void getAllEmployees(){
        int inititalAllEmployeesCount = PersonWarehouse.getAllEmployees().size();

        for(int i =0; i < 50; i++){
            Person testPerson = new Person();
            testPerson.setEmploymentStatus(EMPLOYEE);
            PersonWarehouse.addPerson(testPerson);
        }

        Assert.assertEquals(inititalAllEmployeesCount+50, PersonWarehouse.getAllEmployees().size());

    }

    @Test
    public void getAllFormerEmployees(){
        int inititalAllFormerCount = PersonWarehouse.getAllFormerEmployees().size();

        for(int i =0; i < 255; i++){
            Person testPerson = new Person();
            testPerson.setEmploymentStatus(TERMINATED);
            PersonWarehouse.addPerson(testPerson);
        }

        Assert.assertEquals(inititalAllFormerCount+255, PersonWarehouse.getAllFormerEmployees().size());

    }

}
