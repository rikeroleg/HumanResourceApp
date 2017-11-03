package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.HrContactInfo;
import io.zipcoder.threedaystodeliver.humanresourceapp.Person;
import io.zipcoder.threedaystodeliver.humanresourceapp.PersonHandler;
import io.zipcoder.threedaystodeliver.humanresourceapp.StreetAddress;

import java.time.LocalDate;

public class ProspectMenu extends Menu{

    enum ProspectSelectionOptions { ADD, UPDATE, HOME, EXIT}

    public static final ProspectMenu INSTANCE = new ProspectMenu();

    private static Person currentPerson = null;

    private ProspectMenu(){
        super(ProspectSelectionOptions.values());
    }

    @Override
    public void display(){
        String userInput;
        do {
            if (currentPerson == null){
                System.out.println("No prospect selected");
            } else {
                System.out.println("Selected prospect: "+currentPerson.getContactInfo().getName());
            }
            userInput = this.getMenuInput().toUpperCase();
            try {
                selectOption(userInput);
            } catch (IllegalArgumentException iae) {
                super.handleIllegalArgumentException(userInput, iae);
            } catch (NullPointerException npe) {
                super.handleNullPointerException(npe);
            }
        } while (!"Home".equalsIgnoreCase(userInput));
    }

    @Override
    public void selectOption(String userInput) {
        switch (ProspectSelectionOptions.valueOf(userInput)){
            case ADD:
                addNewProspect();
                break;
            case UPDATE:
                updateProspect();
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
        addResume();
        addScore();
    }

    private void createAndSetActiveNewProspect() {
        HrContactInfo requestedInfo = this.inputAllContactInfo();
        Person newProspect = PersonHandler.createProspect(requestedInfo);
        currentPerson = newProspect;
        System.out.println("New prospect, " + currentPerson.getContactInfo().getName() + ", added with ID: " +
                currentPerson.getId()+".");
    }

    private void addScore() {
        String input = "";
        do {
            System.out.println("Please update prospect score. Enter [Add] to do so now or [Skip] to do so later.");
            input = this.getUserInput();
            if(!"skip".equalsIgnoreCase(input) && "add".equalsIgnoreCase(input)) {
                System.out.println("Please enter score:");
                Double score = SanitizeTools.getEnforcedDoubleInput();
                currentPerson.setScore(score);
            } else if ("skip".equalsIgnoreCase(input)){
                System.out.println("Score update skipped.");
            } else {
                System.out.println("Please try again.");
            }
        } while (!"skip".equalsIgnoreCase(input) && !"add".equalsIgnoreCase(input));
    }

    private void addResume() {
        System.out.println("Please add resume. Enter [Skip] to add one later.");
        String resume = this.getUserInput();
        if (!"skip".equalsIgnoreCase(resume)){
        currentPerson.setResume(resume);
        System.out.println("Resume added");
        } else {
            System.out.println("Resume addition skipped.");
        }
    }

    private void updateProspect(){
        if (currentPerson == null) {
            setActiveProspect();
        }
        updateProspectField();
    }

    private void setActiveProspect() {
        String input = "";
        do {
            System.out.println("Find by [ID] or [Name]?");
            input = this.getUserInput();
        } while (!"cancel".equalsIgnoreCase(input));
    }


    private void updateProspectField() {
        String input;
        do {
            System.out.println("Pick [back] to return to the prospect menu.");
            System.out.println("Selected: \n"+currentPerson.toString()+"\n Please pick a field to update: ");
            input = this.getUserInput().toLowerCase();
            switch(input) {
                case "score":
                    System.out.println("Please enter new score.");
                    Double newScore = SanitizeTools.getEnforcedDoubleInput();
                    currentPerson.setScore(newScore);
                    System.out.println("The new score is ["+currentPerson.getScore()+"].");
                    break;
                case "resume":
                    System.out.println("Please enter new resume.");
                    String newResume = this.getUserInput();
                    currentPerson.setResume(newResume);
                    System.out.println("The new resume is ["+currentPerson.getResume()+"].");
                    break;
                case "id":
                    System.out.println("Please enter new ID.");
                    String newId = this.getUserInput();
                    currentPerson.setId(newId);
                    System.out.println("The new ID is ["+currentPerson.getId()+"].");
                    break;
                case "interview date":
                    System.out.println("Please enter new interview date.");
                    LocalDate newIntDate = SanitizeTools.getEnforcedLocalDateInput();
                    currentPerson.setInterviewDate(newIntDate);
                    System.out.println("The new interview date is ["+currentPerson.getInterviewDate()+"].");
                    break;
                case "name":
                    System.out.println("Please enter new name.");
                    String newName = this.getUserInput();
                    currentPerson.getContactInfo().setName(newName);
                    System.out.println("The new name is ["+currentPerson.getContactInfo().getName()+"].");
                    break;
                case "email":
                    System.out.println("Please enter new email address.");
                    String newEmail = this.getUserInput();
                    currentPerson.getContactInfo().setEmail(newEmail);
                    System.out.println("The new email is ["+currentPerson.getContactInfo().getEmail()+"].");
                    break;
                case "address":
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
                    currentPerson.getContactInfo().getStreetAddress().changeStreetAddress(inputAddressLine1, inputAddressLine2, inputCity, inputState, inputZipCode);
                    System.out.println("The new address is ["+currentPerson.getContactInfo().getStreetAddress()+"].");
                    break;
                case "phone":
                    System.out.println("Please enter new phone number");
                    String newPhone = this.getUserInput();
                    currentPerson.getContactInfo().setPhone(newPhone);
                    System.out.println("The new ID is ["+currentPerson.getContactInfo().getPhone()+"].");
                    break;
                case "hire":

                    break;
                case "back":
                    return;
            }
        } while (!"back".equalsIgnoreCase(input));
    }

}
