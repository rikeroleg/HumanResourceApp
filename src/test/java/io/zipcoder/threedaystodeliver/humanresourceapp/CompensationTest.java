package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

public class CompensationTest {

    @Test
    public void setTypeAndAmount(){
        Compensation compensation = new Compensation();
        compensation.setTypeAndAmount(Compensation.compensationType.Monthly, 5000);
        Assert.assertEquals(Compensation.compensationType.Monthly, compensation.getCompensationType());
    }

    @Test
    public void setBonus(){
        Compensation compensation = new Compensation();
        compensation.setBonus(4000);
        Assert.assertEquals(4000, compensation.getBonus());

    }
}
