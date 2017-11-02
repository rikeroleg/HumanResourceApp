package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Human Resources Application Manager\nPlease Select an option: \n1.[Prospects]    2.[Employees]   3.[Print Reports]\n");
        int tier1 = scanner.nextInt();
        switch (tier1){
            case 1:
                System.out.println("1.[Add New Prospect]   2.[Select Existing Prospect]");
                int prospectTier2 = scanner.nextInt();
                switch (prospectTier2){
                    case 1:
                        HrContactInfo();
                        break;
                    case 2:
                        System.out.println("1.[Select By ID]   2.[Select By Name]");
                        int prospectTier3 = scanner.nextInt();
                        switch (prospectTier3){
                            case 1:
                                selectById();
                                System.out.println("1.[Update Contact Info]   2.[Hire This Prospect]");
                                int prospectTier4 = scanner.nextInt();
                                switch (prospectTier4){
                                    case 1:
                                        // display current contact info
                                        //Update prospect contact Info
                                        break;
                                    case 2:
                                        //Hire this prospect
                                        break;
                                }
                        }
                                break;
                            case 2:
                                selectByName();
                                break;
                        }
                        break;
                }
                break;
            case 2:
                System.out.println("1.[Hire New Employee]   2.[Make Changes To Existing Employee]");
                int employeeTier2 = scanner.nextInt();
                switch (employeeTier2){
                    case 1:
                        hireProspect();
                        break;
                    case 2:
                        //Update Employee Info
                        break;
                }
                break;
            case 3:
                // Print People
                PersonWarehouse printPeople = new PersonWarehouse();
                System.out.print(printPeople.getAllPeople());
                break;
        }





    }

    public Person currentPerson;
    Scanner scan = new Scanner(System.in);

    public void hireEmployee() {
        inputNewEmployeeInfo();
    }

    public void inputNewEmployeeInfo() {
        System.out.print("Enter hire date (yyyy-mm-dd): ");
        String inputHireDate = getInput();
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

        LocalDate hireDate = LocalDate.parse(inputHireDate);
        currentPerson.setHiredDate(hireDate);
        currentPerson.setTitle(inputJobTitle);
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
        currentPerson.setEmploymentStatus(EmploymentStatus.EMPLOYEE);
        currentPerson.setCompensation(newCompensation);


    }

    public String getInput() {
        return null;
    }

    /*
    public static String HrContactInfo(String prompt){
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        String in = scan.nextLine();
        return in;
    }

    public static void HrContactInfo(){
        HrContactInfo("Enter Name: ");
        HrContactInfo("Enter Address Line 1: ");
        HrContactInfo("Enter Address Line 2: ");
        HrContactInfo("Enter City: ");
        HrContactInfo("Enter State: ");
        HrContactInfo("Enter Zip Code: ");
        HrContactInfo("Enter Phone Number: ");
        HrContactInfo("Enter Email Address: ");
    }

    public static void hireProspect(){
        HrContactInfo("Enter Hire Date Year: ");
        HrContactInfo("Enter Hire Date Month: ");
        HrContactInfo("Enter Hire Date Day: ");
        HrContactInfo("Enter Job Title: ");
        HrContactInfo("Enter Paid Monthly/Hourly/Project");
        HrContactInfo("Enter Salary: ");
        HrContactInfo("Enter Bonus: ");
        HrContactInfo("Enter PTO For The Year: ");
        HrContactInfo("Opt In To Medical coverage? Y/N: ");
        HrContactInfo("Opt In To Dental Coverage? Y/N: ");
        HrContactInfo("Opt In To Vision Coverage? Y/N: ");
        HrContactInfo("Opt In to Prescription Coverage? Y/N: ");
        HrContactInfo("Enter Retirement Match %s: ");
    }

    public static void selectById(){
        HrContactInfo("Enter ID: ");
        PersonWarehouse personWarehouse = new PersonWarehouse();
        //System.out.println(personWarehouse.getPersonById());
    }

    public static void selectByName(){
        HrContactInfo("Enter Name: ");
        PersonWarehouse personWarehouse = new PersonWarehouse();
        //System.out.println(personWarehouse.getPersonByName());
    }
    */



    // method - add new prospect, creates a prospect based on inputted contact info
    // will need to create an HrContactInfo object and pass it to the person handler
    // method that creates one:

    /* methods that somehow got deleted

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

    public void hirePerson() {
        System.out.print("Enter hire date year: ");
        int inputHireDateYear = scan.nextInt();
        System.out.print("Enter hire date month: ");
        int inputHireDateMonth = scan.nextInt();
        System.out.print("Enter hire date day: ");
        int inputHireDateDay = scan.nextInt();
        scan.next();
        System.out.println("Enter job title: ");
        String inputJobTitle = scan.nextLine();
        System.out.println("Enter paid Monthly/Hourly/Project");
        System.out.print("Enter salary: ");
        double inputSalary = scan.nextDouble();
        System.out.print("Enter bonus: ");
        double inputBonus = scan.nextDouble();
        System.out.print("Enter PTO for the year: ");
        double inputPTO = scan.nextDouble();
        scan.next();
        System.out.print("Opt in to medical coverage? y/n: ");
        String inputMedical = scan.nextLine();
        System.out.print("Opt in to dental coverage? y/n: ");
        String inputDental = scan.nextLine();
        System.out.print("Opt in to vision coverage? y/n: ");
        String inputVision = scan.nextLine();
        System.out.print("Opt in to prescription coverage? y/n: ");
        String inputPrescription = scan.nextLine();
        System.out.print("Enter retirement match %: ");
        double inputRetirementMatch = scan.nextDouble();

        Date hireDate = new Date(inputHireDateYear, inputHireDateMonth, inputHireDateDay);
        Compensation newCompensation = new Compensation();
        newCompensation.setBonus(inputBonus);
        newCompensation.setTypeAndAmount();

    }
     */




}



