package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

public class HrContactInfoTest {

    @Test
    public void setNameTest() {
        HrContactInfo hrContactInfo = new HrContactInfo();
        hrContactInfo.setName("Katherine");
        Assert.assertEquals("Katherine", hrContactInfo.getName());
    }

    @Test
    public void setStreetAddressTest() {
        StreetAddress streetAddress = new StreetAddress("Line 1",
        "Line 2", "City", "STATE", "19801");
        HrContactInfo hrContactInfo = new HrContactInfo();
        hrContactInfo.setStreetAddress(streetAddress);
        Assert.assertEquals(streetAddress, hrContactInfo.getStreetAddress());
    }
}
