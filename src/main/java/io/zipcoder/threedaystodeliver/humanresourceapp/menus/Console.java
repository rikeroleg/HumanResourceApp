package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Console {
    static Scanner scanner = new Scanner(System.in);
    public static Person currentPerson;
    PersonWarehouse singletonInstance = PersonWarehouse.getInstance();



    private static void prospectsMainMenu() {
        System.out.println("1.[Add New Prospect]   2.[Select Existing Prospect]   3.[View All Prospects]");
        int prospectTier2 = scanner.nextInt();
        switch (prospectTier2) {
            case 1:
                addNewProspect();
                break;
            case 2:
                makeChangesToExistingProspect();
            case 3:
                //Print

        }
    }

    public static void employeesMainMenu() {
        String input;
        do {
            System.out.println("1.[Hire New Employee]   2.[Make Changes To Existing Employee]");
            input = getInput();

        }while( !("1".equals(input)) && !("2".equals(input)) );

        if ("1".equals(input)) {
            currentPerson = PersonFactory.createPerson(inputAllContactInfo());
            hireEmployee();
        }
        else {
            do {
                System.out.println("\n\nSelect an employee by ID or by name?\n");
                System.out.println("1.[ID]   2.[Name]");
                System.out.println(": ");
                input = getInput();
            }while( !("1".equals(input)) && !("2".equals(input)) );

            if("1".equals(input)) {
                currentPerson = getPersonById();
            }
            else {
                currentPerson = getPersonByName();
            }
            updateExistingEmployee();
        }



    }

    private static void updateExistingEmployee() {
        String input;
        do {
            System.out.println("What do we need to change?\n");
            System.out.println("1. [Contact Information]   2. [Job Title & Compensation]  \n" +
                               "3. [Compensation]   4. [Finished Updating]");
            System.out.print(": ");
            input = getInput();
        }while ( !("1".equals(input)) && !("2".equals(input)) && !("3".equals(input)) && !("4".equals(input)) );

        switch (input) {
            case "1":   {
                            break;
                        }
            case "2":   {
                            System.out.print("Enter new job title: ");
                            currentPerson.setTitle(getInput());
                        }
            case "3":   {
                            currentPerson.setCompensation(changeCompensation());
                            break;
                        }
            case "4":   {
                            break;
                        }
        }


    }

    private static void makeChangesToExistingProspect() {
        System.out.println("1.[Select By ID]   2.[Select By Name]");
        int prospectTier3 = scanner.nextInt();
        switch (prospectTier3) {
            case 1:
                currentPerson = getPersonById();
                updateOrHireProspect();

            case 2:
                currentPerson = getPersonByName();
                updateOrHireProspect();
                break;
        }
    }

    private static void updateOrHireProspect() {
        System.out.println("1.[Update Contact Info]   2.[Hire This Prospect]");
        int prospectTier4 = scanner.nextInt();
        switch (prospectTier4) {
            case 1:
                currentPerson.setContactInfo(inputAllContactInfo());
                break;
            case 2:
                hireEmployee();
                break;
        }
    }

    public static void hireEmployee() {
        inputNewEmployeeInfo();
    }

    public static void inputNewEmployeeInfo() {
        System.out.print("Enter hire date (yyyy-mm-dd): ");
        LocalDate inputHireDate = getDateInput();
        System.out.println("Enter job title: ");
        String inputJobTitle = getInput();
        Compensation newCompensation = changeCompensation();
        currentPerson = PersonHandler.hire(currentPerson, inputHireDate, inputJobTitle, newCompensation);

    }

    private static Compensation changeCompensation() {
        System.out.println("Enter paid Monthly/Hourly/Project: ");
        String inputPayType = getInput().toLowerCase();
        System.out.print("Enter salary: ");
        double inputSalary = Double.parseDouble(getInput());
        System.out.print("Enter bonus: ");
        double inputBonus = Double.parseDouble(getInput());
        System.out.print("Enter PTO for the year: ");
        double inputPTO = Double.parseDouble(getInput());
        System.out.print("Opt in to medical coverage? y/n: ");
        String inputMedical = getInput();
        System.out.print("Opt in to dental coverage? y/n: ");
        String inputDental = getInput();
        System.out.print("Opt in to vision coverage? y/n: ");
        String inputVision = getInput();
        System.out.print("Opt in to prescription coverage? y/n: ");
        String inputPrescription = getInput();
        System.out.print("Enter retirement match %: ");
        double inputRetirementMatch = Double.parseDouble(getInput());

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



    public static Person getPersonById() {
        PersonWarehouse personWarehouse = PersonWarehouse.getInstance();
        System.out.println("Enter ID: ");
        String in = scanner.nextLine();
        Person match = personWarehouse.getPersonById(in);
        return match;
    }

    public static Person getPersonByName() {
        PersonWarehouse personWarehouse = PersonWarehouse.getInstance();
        System.out.println("Enter Name: ");
        String in = scanner.nextLine();
        ArrayList<Person> listOfMatches = personWarehouse.getPersonByName(in);
        System.out.println("Please select from the list");
        int i = 1;
        for(Person person : listOfMatches){
            System.out.println(i + ": " + person.getContactInfo().getName());
            i++;
        }
        String select = scanner.nextLine();
        int index = Integer.parseInt(select);
        return listOfMatches.get(index-1);

    }

    public void terminateEmployee(){
        String input;
        LocalDate terminationDate;

        do {
            System.out.println("Enter termination date in the form YYYY-MM-DD:  ");
            input = getInput();
            terminationDate = LocalDate.parse(input);
        }while (terminationDate==null);
        Person currentPerson=new Person();
        currentPerson.setTerminationDate(terminationDate);

        System.out.println("Reason for termination:  ");
        input=getInput();
        currentPerson.setReasonForTermination(input);

        System.out.println("Notes from Exit Interview:  ");
        input=getInput();
        currentPerson.setExitInterview(input);

        currentPerson.setCompensation(null);
        currentPerson.setEmploymentStatus(EmploymentStatus.TERMINATED);
        currentPerson.setTitle("");

    }




    public String printingAllPeople() {

        String showAllEmployeeInfo = "";

        PersonWarehouse allEmployeeInfo = PersonWarehouse.getInstance();

        for (Person a : allEmployeeInfo.getAllPeople()) {

            showAllEmployeeInfo += a.toString();
        }
        return showAllEmployeeInfo;
    }


    public void reportingMenu() {

        boolean inputOutOfRange = false;

        while (!inputOutOfRange) {

            System.out.println("Please press 1: for Employee or 2: for former...");
            try {

                String getInputChoice = getInput();

                if ("1".equals(getInputChoice)) { /// For Showing All Employee Info

                    PersonWarehouse showAllEmployeeInfo = PersonWarehouse.getInstance();

                    for (Person i : showAllEmployeeInfo.getAllEmployees()) {
                        System.out.println(i);
                    }


                } else if ("2".equals(getInputChoice)) {  /// For Showing All Former Info

                    PersonWarehouse showAllFormerInfo = PersonWarehouse.getInstance();
                    for (Person i : showAllFormerInfo.getAllFormerEmployees()) {
                        System.out.println(i);
                    }

                } else if ("3".equals(getInputChoice)) {  /// For Showing All Prospect Info

                    PersonWarehouse showAllProspectInfo = PersonWarehouse.getInstance();
                    for (Person i : showAllProspectInfo.getAllProspects()) {
                        System.out.println(i);
                    }
                } else {
                    inputOutOfRange = true;
                }

            } catch (Exception e) {
                System.out.println("Try again please, select 1  or 2...");
            }
        }

    }
}