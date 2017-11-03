package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

public class ReportingMenu extends Menu{

    enum ReportingSelectionOptions {ALL, PROSPECT, EMPLOYEE, HOME, EXIT}

    public static final ReportingMenu INSTANCE = new ReportingMenu();

    private ReportingMenu(){
        super(ReportingSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch (ReportingSelectionOptions.valueOf(userInput)){
            case PROSPECT:
                //something
                break;
            case EMPLOYEE:
                //something
                break;
            case ALL:
                //something
                break;
            case HOME:
                //go back up somehow
                break;
            case EXIT:
                System.exit(0);
                return;
        }
    }

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
