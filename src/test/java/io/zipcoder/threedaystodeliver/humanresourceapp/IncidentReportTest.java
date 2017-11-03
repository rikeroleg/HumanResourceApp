package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

public class IncidentReportTest {

    @Test
    public void addPersonToIncidentReportTest() {
        IncidentReport testReport = new IncidentReport(IncidentReport.IncidentCategory.type1, "test description");
        Person testPerson = new Person();

        testReport.addPersonToIncidentReport(testPerson);
        Assert.assertEquals(testPerson, testReport.getPersonsInvolved().get(0));
    }

    @Test
    public void removePersonFromIncidentReportTest() {

    }
}
