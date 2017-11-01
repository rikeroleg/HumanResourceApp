package io.zipcoder.threedaystodeliver.humanresourceapp;

public class PersonHandler {

    public static void createProspect(HrContactInfo hrContactInfo){
        Person person = PersonFactory.createPerson(hrContactInfo);
        person.setEmploymentStatus(EmploymentStatus.PROSPECT);

    }

    public static void hire(Person person){

    }

    public static void terminate(Person person) {}

    public static void promote(Person person, String newTitle, double newpayRate){

    }

    public static String getAllPersonInfo(Person person){
        return null;
    }

}
