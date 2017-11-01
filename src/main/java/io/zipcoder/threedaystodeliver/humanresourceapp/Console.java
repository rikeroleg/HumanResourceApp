package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Scanner;

public class Console {

    public static void main(String[] args) {


    }

    public Person currentPerson;

    //methods for all employee types
    public HrContactInfo inputContactInfo() {
        Scanner scan = new Scanner(System.in);

        return null;
    }

    public void printCurrentPerson() {
        System.out.println(currentPerson);
    }


    // prospect methods
    public void addNewProspect() {
        HrContactInfo requestedInfo = inputContactInfo();
        Person newProspect = PersonHandler.createProspect(requestedInfo);
        currentPerson = newProspect;
        printCurrentPerson();
    }





}
