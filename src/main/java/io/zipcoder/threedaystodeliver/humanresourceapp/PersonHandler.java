package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Date;

public class PersonHandler {

    public static Person createProspect(HrContactInfo hrContactInfo){
        Person prospect = PersonFactory.createPerson(hrContactInfo);
        prospect.setEmploymentStatus(EmploymentStatus.PROSPECT);

        return prospect;
    }

    public static Person hireFromProspect(Person person, Date date, Compensation compensation){
        Person employee = person;
        employee.setEmploymentStatus(EmploymentStatus.EMPLOYEE);
        employee.setHiredDate(date);
        employee.setCompensation(compensation);

        return employee;
    }

    public static Person hireFromHrInfo(HrContactInfo info, Date date, Compensation compensation){
        Person employee = PersonFactory.createPerson(info);
        employee.setEmploymentStatus(EmploymentStatus.EMPLOYEE);
        employee.setHiredDate(date);
        employee.setCompensation(compensation);

        return employee;
    }

    public static Person terminate(Person person, Date terminationDate, String reasonForTermination, String exitInterview, Compensation postEmployComp) {
        Person formerEmployee = person;
        formerEmployee.setTerminationDate(terminationDate);
        formerEmployee.setReasonForTermination(reasonForTermination);
        formerEmployee.setExitInterview(exitInterview);
        formerEmployee.setPostEmploymentComp(postEmployComp);
        formerEmployee.setEmploymentStatus(EmploymentStatus.TERMINATED);
        formerEmployee.setCompensation(null);

        return formerEmployee;
    }

    public static Person promote(Person person, String newTitle, double newpayRate){
        return null;
    }

    public static String getAllPersonInfo(Person person){
        return null;
    }

}
