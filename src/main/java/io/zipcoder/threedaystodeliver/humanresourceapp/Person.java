package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Date;

public class Employee extends Prospect {

    //current
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

}
