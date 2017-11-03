package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.HrContactInfo;
import io.zipcoder.threedaystodeliver.humanresourceapp.Person;
import io.zipcoder.threedaystodeliver.humanresourceapp.PersonHandler;
import io.zipcoder.threedaystodeliver.humanresourceapp.StreetAddress;

public class ProspectMenu extends Menu{

    enum ProspectSelectionOptions { ADD, UPDATE, HOME, EXIT}

    public static final ProspectMenu INSTANCE = new ProspectMenu();

    private static Person currentPerson = null;

    private ProspectMenu(){
        super(ProspectSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        System.out.println("Selected prospect"+currentPerson.getContactInfo().getName());
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

    }

}
