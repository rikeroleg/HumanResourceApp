package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

public class EmployeeMenu extends Menu{

    enum EmployeeSelectionOptions { ADD, UPDATE, HOME, EXIT}

    public static final EmployeeMenu INSTANCE = new EmployeeMenu();

    private EmployeeMenu(){
        super(EmployeeSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch (EmployeeSelectionOptions.valueOf(userInput)){
            case ADD:
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
