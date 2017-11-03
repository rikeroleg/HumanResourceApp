package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

public class CompensationTest {

    Compensation compensation = new Compensation();

    @Test
    public void setAndGetPtoMaxPerYearTest() {
        compensation.setPtoMaxPerYear(20);
        double expected = 20;
        double actual = compensation.getPtoMaxPerYear();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void usePTOTest() {
        compensation.setUsePTO(5);
        double expected = 5;
        double actual = compensation.getUsePTO();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getPtoRemainingTest() {
        compensation.setPtoMaxPerYear(15);
        compensation.getPtoRemaining();
        compensation.setUsePTO(5);
        compensation.getUsePTO();
        double expected = 10;
        double actual = compensation.getPtoRemaining();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getPTOusedThisYear() {
        compensation.setPtoMaxPerYear(8);
        compensation.getPtoMaxPerYear();
        compensation.setUsePTO(8);
        compensation.getUsePTO();
        double expected = 8;
        double actual = compensation.getPTOUsedThisYear();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void setAnnGetPayratePayrateTest() {

        compensation.setPayrate(4000);
        double expected = 4000;
        double actual = compensation.getPayrate();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getAndSetisVisionTest() {
        compensation.setVision(true);
        boolean expected = true;
        boolean actual = compensation.getIsVision();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isDentalTest() {
        compensation.setDental(true);
        boolean expected = true;
        boolean actual = compensation.isDental();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAndGettMedicalTest() {
        compensation.setMedical(false);
        boolean expected = false;
        boolean actual = compensation.getIsMedical();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSetAndGetmedical() {
        compensation.setMedical(false);
        boolean expected = false;
        boolean actual = compensation.getIsMedical();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAndSetIsPrescription() {
        compensation.setPrescription(true);
        boolean expected = true;
        boolean actual = compensation.isPrescription();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAndGetRetirementMatching() {
        compensation.setRetirementMatching(0.6);
        double expected = 0.6;
        double actual = compensation.getRetirementMatching();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void setCompensationTypeTest() {

        compensation.setCompensationType(Compensation.compensationType.Monthly);

    }

    @Test
    public void setTypeAndAmount() {
        compensation.setTypeAndAmount(Compensation.compensationType.Monthly, 5000);
        Assert.assertEquals(Compensation.compensationType.Monthly, compensation.getCompensationType());
    }

    @Test
    public void setBonus() {
        compensation.setBonus(4000);
        Assert.assertEquals(4000, compensation.getBonus(), 0.001);

    }


}
