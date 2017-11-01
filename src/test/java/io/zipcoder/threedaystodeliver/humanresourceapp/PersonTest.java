package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PersonTest {

//    @Override
//    public String toString(){
//        return null;
//    }
//
//    public void setContactInfo(HrContactInfo contactInfo) {
////        this.contactInfo = contactInfo;
//    }
////    public Compensation getCompensation() {
////        return compensation;
////    }
//
////    public void setCompensation(Compensation compensation) {
////        this.compensation = compensation;
////    }

    @Test
    public void testHireDateGetAndSet(){
        Person emp1 = new Person();
        Date expected = new Date(123456789);

        emp1.setHiredDate(expected);

        Date actual = emp1.getHiredDate();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testTerminationDateGetAndSet(){
        Person emp1 = new Person();
        Date expected = new Date(123456789);

        emp1.setTerminationDate(expected);

        Date actual = emp1.getTerminationDate();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testReasonForTerminationSetAndGet(){
        Person emp1 = new Person();
        String expected = "Offenses against cats";

        emp1.setReasonForTermination(expected);

        String actual = emp1.getReasonForTermination();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testExitInterviewSetAndGet(){
        Person emp1 = new Person();
        String expected = "Employee refuse to interview";

        emp1.setExitInterview(expected);

        String actual = emp1.getExitInterview();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testResumeStubSetAndGet(){
        Person emp1 = new Person();
        String expected = "Illegibly scribbled on a napkin";

        emp1.setResume(expected);

        String actual = emp1.getResume();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInterviewDateGetAndSet(){
        Person emp1 = new Person();
        Date expected = new Date(89345678);

        emp1.setInterviewDate(expected);

        Date actual = emp1.getInterviewDate();

        Assert.assertEquals(expected.toString(), actual.toString());
    }
//    public Date getInterviewDate() {
//        return interviewDate;
//    }
//
//    public void setInterviewDate(Date interviewDate) {
//        this.interviewDate = interviewDate;
//    }
//
//    public double getScore() {
//        return score;
//    }
//
//    public void setScore(double score) {
//        this.score = score;
//    }
//
//
//    public HrContactInfo getContactInfo() {
//        return contactInfo;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public EmploymentStatus getEmploymentStatus() {
//        return employmentStatus;
//    }
//
//    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
//        this.employmentStatus = employmentStatus;
//    }
//
//
}
