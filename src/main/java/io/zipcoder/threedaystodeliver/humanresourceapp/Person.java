package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Date;

public class Person {

    // name and contact stuff
    private HrContactInfo contactInfo = new HrContactInfo();

    //current
    private String id;
    private EmploymentStatus employmentStatus;
    private Compensation compensation;
    private Date hiredDate;

    //former
    private Date terminationDate;
    private String reasonForTermination;
    private String exitInterview;
    private Compensation postEmploymentComp;

    //prospect
    private String resume;
    private Date interviewDate;
    private double score;

    public HrContactInfo getContactInfo() {
        return contactInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Enum getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}
