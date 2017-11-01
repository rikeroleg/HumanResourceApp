package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Date;

public class Person {

    // name and contact stuff
    private HrContactInfo contactInfo = new HrContactInfo();

    //current
    private String id="";
    private EmploymentStatus employmentStatus;
    private Compensation compensation;
    private Date hiredDate;


    //former
    private Date terminationDate;
    private String reasonForTermination = "";
    private String exitInterview = "";

    //prospect
    private String resume = "";
    private Date interviewDate;
    private double score = 0;

    @Override
    public String toString(){

////        private Compensation compensation=new Compensation();
        String returnMe = contactInfo.toString()+
                "Employee ID:  " + id + "\n" +
                "Employment Status:  " + employmentStatus + "\n" +
                "Entrance Interview Date:  " + interviewDate + "\n" +
                "Resume Abstract:  " + resume + "\n" +
                "Hire Date:  " + hiredDate + "\n" +
                "Termination Date:  " + terminationDate + "\n" +
                "Reason For Termination:  " + reasonForTermination + "\n" +
                "Exit Interview Notes:  " + exitInterview + "\n" +
                "Employee Score:  " + score + "\n\n" +
                contactInfo.getName()+"'s Compensation:\n";

        if (compensation==null)
        {
            returnMe+= (compensation.toString() + "\n\n");
        }
        else
        {
            returnMe+= "\n";
        }
        
        return (returnMe);

    }

    public void setContactInfo(HrContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Compensation getCompensation() {
        return compensation;
    }

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getReasonForTermination() {
        return reasonForTermination;
    }

    public void setReasonForTermination(String reasonForTermination) {
        this.reasonForTermination = reasonForTermination;
    }

    public String getExitInterview() {
        return exitInterview;
    }

    public void setExitInterview(String exitInterview) {
        this.exitInterview = exitInterview;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    public HrContactInfo getContactInfo() {
        return contactInfo;
    }

    public String getId() {
        return this.id;
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
