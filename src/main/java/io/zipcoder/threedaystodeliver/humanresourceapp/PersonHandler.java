package io.zipcoder.threedaystodeliver.humanresourceapp;

import io.zipcoder.threedaystodeliver.humanresourceapp.exceptions.NotAnEmployeeException;

import java.util.Date;

public class PersonHandler {

    public static Person createProspect(HrContactInfo hrContactInfo){
        Person prospect = PersonFactory.createPerson(hrContactInfo);
        prospect.setEmploymentStatus(EmploymentStatus.PROSPECT);

        return prospect;
    }

    public static Person hire(Person person, Date date, String title, Compensation compensation){
        Person employee = person;
        employee.setEmploymentStatus(EmploymentStatus.EMPLOYEE);
        employee.setHiredDate(date);
        employee.setTitle(title);
        employee.setCompensation(compensation);

        return employee;
    }

    public static Person hire(HrContactInfo info, Date date, String title, Compensation compensation){
        Person employee = PersonFactory.createPerson(info);

        return hire(employee, date, title, compensation);
    }

    public static Person terminate(Person person, Date terminationDate, String reasonForTermination, String exitInterview, Compensation postEmployComp) {
        Person formerEmployee = person;
        formerEmployee.setTerminationDate(terminationDate);
        formerEmployee.setReasonForTermination(reasonForTermination);
        formerEmployee.setExitInterview(exitInterview);
        formerEmployee.setEmploymentStatus(EmploymentStatus.TERMINATED);
        formerEmployee.setCompensation(null);

        return formerEmployee;
    }

    public static void changePosition(Person person, String newTitle, double newpayRate, double newBonus, double newPTO) throws NotAnEmployeeException {
        if(EmploymentStatus.EMPLOYEE == person.getEmploymentStatus()){
            person.setTitle(newTitle);
            person.getCompensation().setPayrate(newpayRate);
            person.getCompensation().setBonus(newBonus);
            person.getCompensation().setPtoMaxPerYear(newPTO);
        } else {
            throw new NotAnEmployeeException();
        }

    }

    public static String getAllPersonInfo(Person person){
        return person.toString();
    }

}
