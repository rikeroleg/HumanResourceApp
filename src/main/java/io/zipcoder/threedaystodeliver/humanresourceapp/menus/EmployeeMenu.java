package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.HrContactInfo;
import io.zipcoder.threedaystodeliver.humanresourceapp.Person;
import io.zipcoder.threedaystodeliver.humanresourceapp.PersonHandler;

public class EmployeeMenu extends Menu{

    enum EmployeeSelectionOptions { ADD, UPDATE, HOME, EXIT}

    public static final EmployeeMenu INSTANCE = new EmployeeMenu();

    private static Person currentPerson = null;

    private EmployeeMenu(){
        super(EmployeeSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch (EmployeeSelectionOptions.valueOf(userInput)){
            case ADD:
                addNewEmployee();
                //something
                break;
            case UPDATE:
                //
                break;
            case HOME:
                //go up
                break;
            case EXIT:
                System.exit(0);
                return;
        }
    }

    private void addNewEmployee(){
        createAndSetActiveNewEmployee();
        System.out.println("New employee, "+currentPerson.getContactInfo().getName()+", added with ID: "+
                currentPerson.getId()+".");

        System.out.println("Please add resume. Enter [Skip] to add one later.");
        String resume = this.getUserInput();
        if (!"skip".equalsIgnoreCase(resume)){
            currentPerson.setResume(resume);
            System.out.println("Resume added");
        } else {
            System.out.println("Resume addition skipped.");
        }

        System.out.println("Please update employee score. Enter [Add] to do so now or [Skip] to do so later.");
        String input = this.getUserInput();
        if(!"skip".equalsIgnoreCase(input)) {
            System.out.println("Please enter score:");
            Double score = SanitizeTools.getEnforcedDoubleInput();
            currentPerson.setScore(score);
        } else {
            System.out.println("Score update skipped.");
        }

        currentPerson.setCompensation(changeCompensation());


    }

    private void createAndSetActiveNewEmployee() {
        HrContactInfo requestedInfo = this.inputAllContactInfo();
        Person newEmployee = PersonHandler.createEmployee(requestedInfo);
        currentPerson = newEmployee;
    }
//
//    private void prospectMenu() {
//        ProspectMenu prospectMenu = new ProspectMenu();
//        prospectMenu.display();
//    }
//
//    private void employeeMenu() {
//        EmployeeMenu employeeMenu = new EmployeeMenu();
//        employeeMenu.display();
//    }
//
//    private void reportingMenu() {
//        ReportingMenu reportingMenu = new ReportingMenu();
//        reportingMenu.display();
//    }

}
