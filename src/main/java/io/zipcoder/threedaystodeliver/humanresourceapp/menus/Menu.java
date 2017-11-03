package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.Compensation;
import io.zipcoder.threedaystodeliver.humanresourceapp.HrContactInfo;
import io.zipcoder.threedaystodeliver.humanresourceapp.StreetAddress;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * Created by leon on 10/24/17.
 * Yup, totally stole most of this from Leon, he makes good stuff.
 */

public abstract class Menu {

    private final Enum[] menuOptions;

    public Menu(Enum[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    abstract public void selectOption(String userInput);

    public void display() {
        String userInput;
        do {
            userInput = this.getMenuInput().toUpperCase();
            try {
                selectOption(userInput);
            } catch (IllegalArgumentException iae) {
                handleIllegalArgumentException(userInput, iae);
            } catch (NullPointerException npe) {
                handleNullPointerException(npe);
            }
        } while (!"Home".equalsIgnoreCase(userInput));
    }

    protected void handleIllegalArgumentException(String illegalArgument, IllegalArgumentException iae) {
        handleException("[ %s ] is an invalid argument.", illegalArgument);
    }

    protected void handleNullPointerException(NullPointerException npe) {
        handleException("Unable to retrieve data with input value.");
    }

    private void handleException(String message, Object... args) {
        System.out.printf(message, args);
    }

    protected HrContactInfo inputAllContactInfo() {
        System.out.print("Enter name: ");
        String inputName = this.getUserInput();
        System.out.print("Enter address line 1: ");
        String inputAddressLine1 = this.getUserInput();
        System.out.print("Enter address line 2: ");
        String inputAddressLine2 = this.getUserInput();
        System.out.print("Enter city: ");
        String inputCity = this.getUserInput();
        System.out.print("Enter state: ");
        String inputState = this.getUserInput();
        System.out.print("Enter zip code: ");
        String inputZipCode = this.getUserInput();
        System.out.print("Enter phone number: ");
        String inputPhoneNumber = this.getUserInput();
        System.out.print("Enter email address: ");
        String inputEmailAddress = this.getUserInput();

        StreetAddress newStreetAddress = new StreetAddress(inputAddressLine1, inputAddressLine2, inputCity, inputState, inputZipCode);
        HrContactInfo newHrContactInfo = new HrContactInfo(inputName, newStreetAddress, inputPhoneNumber, inputEmailAddress);

        return newHrContactInfo;
    }

    public String getMenuInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("===== %s =====\n", getClass().getSimpleName());
        System.out.println("Select option:");
        for (Enum e : menuOptions) {
            System.out.printf("[ %s ] ", e.name());
        }
        System.out.println();
        return scanner.nextLine();
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected Compensation changeCompensation() {
        System.out.println("Enter paid Monthly/Hourly/Project: ");
        String inputPayType = getUserInput().toLowerCase();
        System.out.print("Enter salary: ");
        double inputSalary = Double.parseDouble(getUserInput());
        System.out.print("Enter bonus: ");
        double inputBonus = Double.parseDouble(getUserInput());
        System.out.print("Enter PTO for the year: ");
        double inputPTO = Double.parseDouble(getUserInput());
        System.out.print("Opt in to medical coverage? y/n: ");
        String inputMedical = getUserInput();
        System.out.print("Opt in to dental coverage? y/n: ");
        String inputDental = getUserInput();
        System.out.print("Opt in to vision coverage? y/n: ");
        String inputVision = getUserInput();
        System.out.print("Opt in to prescription coverage? y/n: ");
        String inputPrescription = getUserInput();
        System.out.print("Enter retirement match %: ");
        double inputRetirementMatch = Double.parseDouble(getUserInput());

        Compensation newCompensation = new Compensation();
        switch (inputPayType) {
            case "monthly":
                newCompensation.setTypeAndAmount(Compensation.compensationType.Monthly, inputSalary);
                break;
            case "hourly":
                newCompensation.setTypeAndAmount(Compensation.compensationType.Hourly, inputSalary);
                break;
        }
        newCompensation.setBonus(inputBonus);
        newCompensation.setPtoMaxPerYear(inputPTO);
        if("y".equals(inputMedical)) {
            newCompensation.setMedical(true);
        }
        else {
            newCompensation.setMedical(false);
        }

        if("y".equals(inputDental)) {
            newCompensation.setDental(true);
        }
        else {
            newCompensation.setDental(false);
        }

        if("y".equals(inputVision)) {
            newCompensation.setVision(true);
        }
        else {
            newCompensation.setVision(false);
        }

        if("y".equals(inputPrescription)) {
            newCompensation.setPrescription(true);
        }
        else {
            newCompensation.setPrescription(false);
        }

        newCompensation.setRetirementMatching(inputRetirementMatch);
        return newCompensation;
    }
}


