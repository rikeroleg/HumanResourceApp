package io.zipcoder.threedaystodeliver.humanresourceapp;

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
                                //Search by ID
                                selectByID();
                            case 2:
                                //Search by Name
                                selectByName();
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
                    case 2:
                        //Make changes
                }
                break;
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

    public static void selectByID(){
        HrContactInfo("Enter ID: ");
        //Search by ID method
    }

    public static void selectByName(){
        HrContactInfo("Enter Name: ");
        //Search by Name method
    }


}



