package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Scanner;

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
                //Update prospect contact Info
                break;
            case 2:
                //Hire this prospect
                break;
        }
    }


    public static String HrContactInfo(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        String in = scan.nextLine();
        return in;
    }

    public static void HrContactInfo() {
        String name = HrContactInfo("Enter Name: ");
        String address1 = HrContactInfo("Enter Address Line 1: ");
        String address2 = HrContactInfo("Enter Address Line 2: ");
        String city = HrContactInfo("Enter City: ");
        String state = HrContactInfo("Enter State: ");
        String zip = HrContactInfo("Enter Zip Code: ");
        String phone = HrContactInfo("Enter Phone Number: ");
        String email = HrContactInfo("Enter Email Address: ");
    }

    public static void hireProspect() {
        String hireYear = HrContactInfo("Enter Hire Date Year: ");
        String hireMonth = HrContactInfo("Enter Hire Date Month: ");
        String hireDay = HrContactInfo("Enter Hire Date Day: ");
        String title = HrContactInfo("Enter Job Title: ");
        String pay = HrContactInfo("Enter Paid Monthly/Hourly/Project");
        String salary = HrContactInfo("Enter Salary: ");
        String bonus = HrContactInfo("Enter Bonus: ");
        String pto = HrContactInfo("Enter PTO For The Year: ");
        String medical = HrContactInfo("Opt In To Medical coverage? Y/N: ");
        String dental = HrContactInfo("Opt In To Dental Coverage? Y/N: ");
        String vision = HrContactInfo("Opt In To Vision Coverage? Y/N: ");
        String prescription = HrContactInfo("Opt In to Prescription Coverage? Y/N: ");
        String retirement = HrContactInfo("Enter Retirement Match %s: ");
    }

    public static void getPersonById() {
        PersonWarehouse personWarehouse = new PersonWarehouse();
        System.out.println("Enter ID: ");
        String in = scanner.nextLine();
        personWarehouse.getPersonById(in);
    }

    public static void getPersonByName() {
        PersonWarehouse personWarehouse = new PersonWarehouse();
        System.out.println("Enter Name: ");
        String in = scanner.nextLine();
        personWarehouse.getPersonByName(in);


    }
}







