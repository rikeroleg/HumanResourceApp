package io.zipcoder.threedaystodeliver.humanresourceapp;

public class PersonHandler {

    public static Person createProspect(HrContactInfo hrContactInfo){
        Person prospect = PersonFactory.createPerson(hrContactInfo);
        prospect.setEmploymentStatus(EmploymentStatus.PROSPECT);

        return prospect;
    }

    public static Person hire(Person person){
        return null;
    }

    public static Person terminate(Person person) {
        return null;
    }

    public static Person promote(Person person, String newTitle, double newpayRate){
        return null;
    }

    public static String getAllPersonInfo(Person person){
        return null;
    }

}
