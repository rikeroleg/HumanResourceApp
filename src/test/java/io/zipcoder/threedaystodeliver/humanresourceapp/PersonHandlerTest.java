package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

public class PersonHandlerTest {

//    Create a prospect ->
//    enter information into console
//    create person with entered contact info,
//    add person to warehouse,
//    verify person is in the warehouse
//    information is populated into person

    String name = "Uncle Bob";
    StreetAddress address = new StreetAddress();
    String phone = "123-456-7890";
    String email = "cleancode@forever.com";

    HrContactInfo info = new HrContactInfo(name, address, phone, email);


    @Test
    public void createProspectTypeShouldBeProspectTest(){
        Person person = PersonHandler.createProspect(info);
        Assert.assertEquals( EmploymentStatus.PROSPECT, person.getEmploymentStatus());
    }

    @Test
    public void createProspectAddToWarehouseTest(){
//        PersonWarehouse.
    }

//    Change prospects status during interview stage ->
//    enter information into console
//    infomation updates in person object
//
//    Hire employee from prospect ->
//    enter information into console
//    populate employee fields (start date, salary, etc.)
//
//    Terminate employee ->
//    enter information into console
//    populate former employee fields,
//    remove from current employee lists
//
//    Promote employee ->
//    enter information into console
//    update job title, compensation
//
//    Hire employee from new ->
//    enter information into console
//    create person with entered contact info,
//    add person to warehouse,
//    verify person is in the warehouse
//    information is populated into person
//
//    //Employee record object - arraylist of [all employee fields], date stamp on each one,
//    every time a field is updated, a new entry is added to arraylist
//    Update contact info ->
//    enter information into console
//    contact info updates
//
//    Retrieve a record ->
//    enter id info
//    print all employment info
//
//    Retrieve contact info ->
//    enter id info
//    print contact info
//
//    Update employee's remaining PTO ->
//    subtract entered number of days used from PTO remaining
//
//    Display employee's remaining PTO ->
//    print person's PTO remaining
//
//    Update employee's max PTO for year ->
//    update PTO max
//    update PTO remaining
//
//    Update employee's benefits ->
//    enter info into console
//    benefits fields are updated
//
//    Print list of all people ->
//    all people are printed
//
//    Print list of all prospects ->
//    all prospects are printed
//
//    Print list of all employees ->
//    all employees are printed
//
//    Print list of all terminated employees ->
//    all terminated employees are printed
//
//    Batch updates (all previous methods applied to an arraylist)

}
