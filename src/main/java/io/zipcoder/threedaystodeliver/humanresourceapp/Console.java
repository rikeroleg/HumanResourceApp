package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Scanner;

public class Console {

    public static void main(String[] args) {


    }

    public Person currentPerson;
    Scanner scan = new Scanner(System.in);

    //methods for all employee types
    public HrContactInfo inputContactInfo() {
        System.out.print("Enter name: ");
        String inputName = scan.nextLine();
        System.out.print("Enter address line 1: ");
        String inputAddressLine1 = scan.nextLine();
        System.out.print("Enter address line 2: ");
        String inputAddressLine2 = scan.nextLine();
        System.out.print("Enter city: ");
        String inputCity = scan.nextLine();
        System.out.print("Enter state: ");
        String inputState = scan.nextLine();
        System.out.print("Enter zip code: ");
        String inputZipCode = scan.nextLine();
        System.out.print("Enter phone number: ");
        String inputPhoneNumber = scan.nextLine();
        System.out.print("Enter email address: ");
        String inputEmailAddress = scan.nextLine();

        StreetAddress newStreetAddress = new StreetAddress(inputAddressLine1, inputAddressLine2, inputCity, inputState, inputZipCode);
        HrContactInfo newHrContactInfo = new HrContactInfo(inputName, newStreetAddress, inputPhoneNumber, inputEmailAddress);

        return newHrContactInfo;
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
