package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Scanner;
import java.time.LocalDate;

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
                        switch (prospectTier3) {
                            case 1:
                                selectById();
                                System.out.println("1.[Update Contact Info]   2.[Hire This Prospect]");
                                int prospectTier4 = scanner.nextInt();
                                switch (prospectTier4) {
                                    case 1:
                                        //Update prospect contact Info
                                        break;
                                    case 2:
                                        //Hire this prospect
                                        break;
                                }

                            case 2:
                                selectByName();
                                break;
                        }
                }
            case 2:
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
            case 3:
                // Print People
                PersonWarehouse printPeople = new PersonWarehouse();
                System.out.print(printPeople.getAllPeople());
                break;
            }
    }


    public static String HrContactInfo(String prompt){
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        String in = scan.nextLine();
        return in;
    }

   public Person selectPersonToUpdate(){

       System.out.println("Update by Id (select 1), update by Name (select 2)");
       int menuSelect = scan.nextInt();

       PersonWarehouse people = PersonWarehouse.getInstance();
       Person selectedPerson = null;

       if(menuSelect == 1)      selectedPerson = people.getPersonById();
       else if(menuSelect == 2) selectedPerson = people.getPersonByName();

       return selectedPerson;
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
        //
        }
}



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

    }

    public printAllBySelection(){

    }

    public void selectFieldToUpdate(){
        return;
    }

    public void updateContactName(){
    }

    public void updatePhoneNumber(){

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



