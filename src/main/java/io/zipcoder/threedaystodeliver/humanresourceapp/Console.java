package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.Date;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        Console console = new Console();

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

   public Person selectPersonToUpdate(){

       System.out.println("Update by Id (select 1), update by Name (select 2)");
       int menuSelect = scan.nextInt();

       PersonWarehouse people = PersonWarehouse.getInstance();
       Person selectedPerson = null;

       if(menuSelect == 1)      selectedPerson = people.getPersonById();
       else if(menuSelect == 2) selectedPerson = people.getPersonByName();

       return selectedPerson;
   }

   public int selectFieldToUpdate(){
       return 0;
   }

   public void updateContactName(){
   }

   public void updatePhoneNumber(){

   }

   public void updateBenefitOptions(){
   }

   public Person promoteEmployee(){
       return null;
   }

   public void inputIdNumber(){

   }

   public void inputName(){

   }

    public void hireProspect(){

    }

    public void promoteEmployinee(){

    }

    public void terminateEmployee(){

    }

    public void selectPersonFromList(){

    }

    public printAllByFieldSelection(){

    }





}



