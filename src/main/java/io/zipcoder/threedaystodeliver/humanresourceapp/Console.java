package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Console {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Human Resources Application Manager\nPlease Select an option: \n1.[Prospects]    2.[Employees]   3.[Print Reports]\n");
        int tier1 = scanner.nextInt();
        mainMenu(tier1);
    }

    private static void mainMenu(int tier1){
        switch (tier1) {
            case 1:
                prospectMenu2();
                break;
            case 2:
                employeeMenu2();
                break;
            case 3:
                System.out.print(PersonWarehouse.getInstance().getAllPeople());
                break;
        }
    }

    private static void employeeMenu2() {
        System.out.println("1.[Hire New Employee]   2.[Make Changes To Existing Employee]");
        int employeeTier2 = scanner.nextInt();
        switch (employeeTier2) {
            case 1:
                hireProspect();
                break;
            case 2:
                //Update Employee Info
                break;
        }
    }

    private static void prospectMenu2() {
        System.out.println("1.[Add New Prospect]   2.[Select Existing Prospect]   3.[View All Prospects]");
        int prospectTier2 = scanner.nextInt();
        switch (prospectTier2) {
            case 1:
                HrContactInfo();
                break;
            case 2:
                System.out.println("1.[Select By ID]   2.[Select By Name]");
                int prospectTier3 = scanner.nextInt();
                prospectMenu3(prospectTier3);
            case 3:
                //Print

        }
    }

    private static void prospectMenu3(int prospectTier3) {
        switch (prospectTier3) {
            case 1:
                getPersonById();
                System.out.println("1.[Update Contact Info]   2.[Hire This Prospect]");
                int prospectTier4 = scanner.nextInt();


                prospectMenu4(prospectTier4);

            case 2:
                getPersonByName();
                break;
        }
    }

    private static void prospectMenu4(int prospectTier4) {
        switch (prospectTier4) {
            case 1:
                selectPersonToUpdate();
                break;
            case 2:
                //Hire this prospect
                break;
        }
    }




    public void inputNewEmployeeInfo() {
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

        currentPerson.setHiredDate(inputHireDate);
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

    public void addNewProspect() {
        HrContactInfo requestedInfo = inputAllContactInfo();
        Person newProspect = PersonHandler.createProspect(requestedInfo);
        currentPerson = newProspect;
    }

    public HrContactInfo inputAllContactInfo() {
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



   public static Person selectPersonToUpdate(){

       System.out.println("Update by Id (select 1), update by Name (select 2)");
       int menuSelect = scanner.nextInt();

       PersonWarehouse people = PersonWarehouse.getInstance();
       Person selectedPerson = null;

       if(menuSelect == 1)      selectedPerson = people.getPersonById();
       else if(menuSelect == 2) selectedPerson = people.getPersonByName();

       return selectedPerson;
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
}


    // prospect methods

    public void promoteEmployee(){

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

    public void selectPersonFromList(){



    public String getInput(){

        String input = scan.nextLine();

        return input;
    }

    public LocalDate getDateInput() {

        String dateInput = scanner.nextLine();

        LocalDate date = LocalDate.parse(dateInput);

        return date;





}

    public void employeeMenu() {
        Person currentPerson=new Person();
        String input;
        do {
            System.out.println("\n\nEmployee Menu\n");
            System.out.println("1. Add New Employee");
            System.out.println("2. Update Existing Employee\n");
            System.out.println(": ");
            input = getInput();

        }while( !("1".equals(input)) && !("2".equals(input)) );

        if ("1".equals(input)) {
            currentPerson=new Person();
            currentPerson.setContactInfo(inputAllContactInfo());
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
}




}
