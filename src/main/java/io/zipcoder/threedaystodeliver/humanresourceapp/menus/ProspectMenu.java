package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.HrContactInfo;

import java.util.ArrayList;
import java.util.Scanner;
import io.zipcoder.threedaystodeliver.humanresourceapp.Person;
import io.zipcoder.threedaystodeliver.humanresourceapp.PersonHandler;
import io.zipcoder.threedaystodeliver.humanresourceapp.PersonWarehouse;
import io.zipcoder.threedaystodeliver.humanresourceapp.StreetAddress;

public class ProspectMenu extends Menu{

    enum ProspectSelectionOptions { ADD, UPDATE, HOME, EXIT}

    public static final ProspectMenu INSTANCE = new ProspectMenu();

    public PersonWarehouse personWarehouse = PersonWarehouse.getInstance();

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
        if (personWarehouse.getAllProspects().size()==0)
        {
            System.out.println("There are no prospects currently in the system.");
        }
        else {
            if (currentPerson == null) {
                setActiveProspect();
            }
            updateProspectField();
        }
    }

    private void setActiveProspect() {
        String input = "";
        do {
            System.out.println("Find by [ID] or [Name]?");
            input = this.getUserInput();
        } while (!"ID".equalsIgnoreCase(input) && !"Name".equalsIgnoreCase(input));

        if ("ID".equalsIgnoreCase(input)){
            currentPerson=getPersonById();
        }
        else{
            currentPerson=getPersonByName();
        }
    }

    private Person getPersonByName(){
        Scanner in = new Scanner(System.in);
        Person match=null;
        do {
            System.out.println("Enter Name: ");
            String name = in.nextLine();
            ArrayList<Person> matchList = personWarehouse.getPersonByName(name);
            if (matchList.size()==0) {
                System.out.println("Invalid Name. Choices: \n");
                System.out.println(personWarehouse.getAllPeople());
            }
            else if (matchList.size()==1){
                match=matchList.get(0);
            }
                else
                {
                    do {
                        System.out.println("Multiple matches for \"" + name + ". Choose ID from choices below:\n");
                        for (Person p : matchList) {
                            System.out.println(p.toString());
                        }
                        match = getPersonById();
                        if (!name.equalsIgnoreCase(match.getContactInfo().getName())) {
                            System.out.println("That ID doesn't match any person named " + name);
                        }
                    }while (!name.equalsIgnoreCase(match.getContactInfo().getName()) );
                }

        }while (match==null);
        return match;

    }

    private Person getPersonById(){
        Scanner in = new Scanner(System.in);
        Person match=null;
        do {
            System.out.println("Enter ID: ");
            String id = in.nextLine();
            match = personWarehouse.getPersonById(id);
            if (match == null) {
                System.out.println("Invalid ID. Choices: \n");
                System.out.println(personWarehouse.getAllPeople());
            }
        }while (match==null);
        return match;
    }

    private void updateProspectField() {

    }

}
