package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Console {
    static Scanner scanner = new Scanner(System.in);
    public static Person currentPerson;
    PersonWarehouse singletonInstance = PersonWarehouse.getInstance();

    public static void main(String[] args) {
        System.out.println("Welcome to Human Resources Application Manager\nPlease Select an option: \n1.[Prospects]    2.[Employees]   3.[Print Reports]\n");
        int choice = scanner.nextInt();
        mainMenu(choice);
    }

    private static void mainMenu(int choice){
        switch (choice) {
            case 1:
                prospectsMainMenu();
                break;
            case 2:
                employeesMainMenu();
                break;
            case 3:
                // call reporting menu instead of line below
                System.out.print(PersonWarehouse.getInstance().getAllPeople());
                break;
        }
    }

    /*
    private static void employeeMenu2() {
        System.out.println("1.[Hire New Employee]   2.[Make Changes To Existing Employee]");
        int employeeTier2 = scanner.nextInt();
        switch (employeeTier2) {
            case 1:
                hireEmployee();
                break;
            case 2:
                //Update Employee Info
                break;
        }
    }
    */

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
            System.out.println("\n\nEmployee Menu\n");
            System.out.println("1. Add New Employee");
            System.out.println("2. Update Existing Employee\n");
            System.out.println(": ");
            input = getInput();

        }while( !("1".equals(input)) && !("2".equals(input)) );

        if ("1".equals(input)) {
            currentPerson = PersonFactory.createPerson(inputAllContactInfo());
            hireEmployee();
        }
        else {
            do {
                System.out.println("\n\nSelect an employee by ID or by name?\n");
                System.out.println("1. ID");
                System.out.println("2. Name\n");
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
        currentPerson = PersonHandler.hire(currentPerson, inputHireDate, inputJobTitle, newCompensation);

    }

    public static void addNewProspect() {
        HrContactInfo requestedInfo = inputAllContactInfo();
        Person newProspect = PersonHandler.createProspect(requestedInfo);
        currentPerson = newProspect;
    }

    public static HrContactInfo inputAllContactInfo() {
        System.out.print("Enter name: ");
        String inputName = getInput();
        System.out.print("Enter address line 1: ");
        String inputAddressLine1 = getInput();
        System.out.print("Enter address line 2: ");
        String inputAddressLine2 = getInput();
        System.out.print("Enter city: ");
        String inputCity = getInput();
        System.out.print("Enter state: ");
        String inputState = getInput();
        System.out.print("Enter zip code: ");
        String inputZipCode = getInput();
        System.out.print("Enter phone number: ");
        String inputPhoneNumber = getInput();
        System.out.print("Enter email address: ");
        String inputEmailAddress = getInput();

        StreetAddress newStreetAddress = new StreetAddress(inputAddressLine1, inputAddressLine2, inputCity, inputState, inputZipCode);
        HrContactInfo newHrContactInfo = new HrContactInfo(inputName, newStreetAddress, inputPhoneNumber, inputEmailAddress);

        return newHrContactInfo;
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




    public static String getInput(){

        String input=scanner.nextLine();

        return input;
        }


    public static LocalDate getDateInput() {

        String dateInput = scanner.nextLine();

        LocalDate date = LocalDate.parse(dateInput);

        return date;
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