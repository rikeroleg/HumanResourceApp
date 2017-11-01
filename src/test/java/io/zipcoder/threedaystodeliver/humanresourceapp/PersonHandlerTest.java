package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PersonHandlerTest {

    String name = "Uncle Bob";
    StreetAddress address = new StreetAddress();
    String phone = "123-456-7890";
    String email = "cleancode@forever.com";

    HrContactInfo info = new HrContactInfo(name, address, phone, email);

    @Test
    public void createProspectTypeShouldBeProspectTest(){
        Person prospect = PersonHandler.createProspect(info);
        Assert.assertEquals( EmploymentStatus.PROSPECT, prospect.getEmploymentStatus());
    }

    @Test
    public void createProspectAddToWarehouseTest(){
        PersonWarehouse personWarehouse = PersonWarehouse.getInstance();
        int beforeCount = personWarehouse.getAllPeople().size();
        int expected = 5;

        for (int i = 0; i < 5; i++) {
            Person person = PersonHandler.createProspect(info);
        }

        int afterCount = personWarehouse.getAllPeople().size();
        int actual = afterCount - beforeCount;

        Assert.assertEquals(expected, actual);
    }

//    Change prospects status during interview stage ->
//    enter information into console
//    infomation updates in person object
////
//    @Test
//    public void


//    Hire employee from prospect ->
//    enter information into console
//    populate employee fields (start date, salary, etc.)
//

    @Test
    public void hireProspectChangeTypeTest(){
        Person prospect = PersonHandler.createProspect(info);
        Person employee = PersonHandler.hire(prospect, new Date(), "", new Compensation());

        Assert.assertEquals(EmploymentStatus.EMPLOYEE, employee.getEmploymentStatus());
    }

    @Test
    public void hireProspectHasDateTest(){
        Person prospect = PersonHandler.createProspect(info);
        Date date = new Date();
        Person employee = PersonHandler.hire(prospect, date, "", new Compensation());

        Assert.assertEquals(date, employee.getHiredDate());
    }

    @Test
    public void hireProspectHasCompensationTest(){
        Person prospect = PersonHandler.createProspect(info);
        Compensation compensation = new Compensation();
        compensation.setTypeAndAmount(Compensation.compensationType.Monthly, 2.50);
        Person employee = PersonHandler.hire(prospect, new Date(), "", compensation);

        Assert.assertEquals(Compensation.compensationType.Monthly, employee.getCompensation().getCompensationType());
        Assert.assertEquals(2.50, employee.getCompensation().getPayrate(), 0.001);
    }

    @Test
    public void hireProspectHasTitleTest(){
        String title = "Smooth Operator";
        Person prospect = PersonHandler.createProspect(info);
        Person employee = PersonHandler.hire(prospect, new Date(), title, new Compensation());

        Assert.assertEquals(title, employee.getTitle());
    }

    //
//    Hire employee from new ->
//    enter information into console
//    create person with entered contact info,
//    add person to warehouse,
//    verify person is in the warehouse
//    information is populated into person
//

    @Test
    public void hireFromStreetTest(){
        Person employee = PersonHandler.hire(info, new Date(), "Truck Driver", new Compensation());

        Assert.assertEquals(EmploymentStatus.EMPLOYEE, employee.getEmploymentStatus());
    }



//    Terminate employee ->
//    enter information into console
//    populate former employee fields,
//    remove from current employee lists
//

    @Test
    public void terminateEmployeeTypeTest(){
        Person employee = PersonHandler.hire(info, new Date(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, new Date(), "", "", new Compensation());

        Assert.assertEquals(EmploymentStatus.TERMINATED, formerEmployee.getEmploymentStatus());
    }

    @Test
    public void terminateEmployeePayRateIsNullTest(){
        Person employee = PersonHandler.hire(info, new Date(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, new Date(), "", "", new Compensation());

        Assert.assertNull(formerEmployee.getCompensation());
    }

    @Test
    public void terminatedEmployeeHasExitInterviewTest(){
        String exit = "TERMINATED";
        Person employee = PersonHandler.hire(info, new Date(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, new Date(), "", exit, new Compensation());

        Assert.assertTrue(exit.equals(formerEmployee.getExitInterview()));
    }

    @Test
    public void terminatedEmployeeHasTermDateTest(){
        Date date = new Date();
        Person employee = PersonHandler.hire(info, new Date(1, 1,1 ), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, date, "", "", new Compensation());

        Assert.assertEquals(date, employee.getTerminationDate());
    }

    @Test
    public void terminatedEmployeeHasReasonForTermination(){
        String reason = "code wasn't clean";

        Person employee = PersonHandler.hire(info, new Date(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, new Date(), reason, "", new Compensation());

        Assert.assertEquals(reason, employee.getReasonForTermination());
    }

//    change position employee ->
//    enter information into console
//    update job title, compensation

    @Test
    public void changePositionTitleTest(){



    }


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
