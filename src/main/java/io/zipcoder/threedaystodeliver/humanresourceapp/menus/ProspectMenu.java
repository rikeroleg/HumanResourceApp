package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.HrContactInfo;
import io.zipcoder.threedaystodeliver.humanresourceapp.Person;
import io.zipcoder.threedaystodeliver.humanresourceapp.PersonHandler;
import io.zipcoder.threedaystodeliver.humanresourceapp.StreetAddress;

public class ProspectMenu extends Menu{

    enum ProspectSelectionOptions { ADD, UPDATE, VIEW, HOME, EXIT}

    public static final ProspectMenu INSTANCE = new ProspectMenu();

    private static Person currentPerson = null;

    private ProspectMenu(){
        super(ProspectSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch (ProspectSelectionOptions.valueOf(userInput)){
            case ADD:
                addNewProspect();
                break;
            case UPDATE:
                //
                break;
            case VIEW:
                //view all
                break;
            case HOME:
                return;
            case EXIT:
                System.exit(0);
                return;
        }
    }

    private void addNewProspect(){
        createAndSetActiveNewProspect();
        System.out.println("New prospect, "+currentPerson.getContactInfo().getName()+", added with ID: "+
                currentPerson.getId()+".");

        System.out.println("Please add resume. Enter [Skip] to add one later.");
        String resume = this.getUserInput();
        if (!"skip".equalsIgnoreCase(resume)){
        currentPerson.setResume(resume);
        System.out.println("Resume added");
        } else {
            System.out.println("Resume addition skipped.");
        }

        System.out.println("Please update prospect score. Enter [Add] to do so now or [Skip] to do so later.");
        String input = this.getUserInput();
        if(!"skip".equalsIgnoreCase(input)) {
            System.out.println("Please enter score:");
            Double score = SanitizeTools.getEnforcedDoubleInput();
            currentPerson.setScore(score);
        } else {
            System.out.println("Score update skipped.");
        }
    }

    private void createAndSetActiveNewProspect() {
        HrContactInfo requestedInfo = inputAllContactInfo();
        Person newProspect = PersonHandler.createProspect(requestedInfo);
        currentPerson = newProspect;
    }

    private HrContactInfo inputAllContactInfo() {
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

//    private void employeeMenu() {
//        ProspectMenu employeeMenu = new ProspectMenu();
//        employeeMenu.display();
//    }
//
//    private void reportingMenu() {
//        ReportingMenu reportingMenu = new ReportingMenu();
//        reportingMenu.display();
//    }

}
