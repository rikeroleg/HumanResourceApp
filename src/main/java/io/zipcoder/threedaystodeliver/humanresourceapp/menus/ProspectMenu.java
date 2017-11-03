package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

public class ProspectMenu extends Menu{

    enum ProspectSelectionOptions { ADD, UPDATE, VIEW, HOME, EXIT}

    public static final ProspectMenu INSTANCE = new ProspectMenu();

    private ProspectMenu(){
        super(ProspectSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch (ProspectSelectionOptions.valueOf(userInput)){
            case ADD:
                //something
                break;
            case UPDATE:
                //
                break;
            case VIEW:
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
//        ProspectMenu employeeMenu = new ProspectMenu();
//        employeeMenu.display();
//    }
//
//    private void reportingMenu() {
//        ReportingMenu reportingMenu = new ReportingMenu();
//        reportingMenu.display();
//    }

}
