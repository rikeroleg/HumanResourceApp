package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * Created by leon on 10/24/17.
 * Yup, totally stole most of this from Leon, he makes good stuff.
 */

public abstract class Menu {

    private final Enum[] menuOptions;

    public Menu(Enum[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    abstract public void selectOption(String userInput);

    public void display() {
        String userInput;
        do {
            userInput = this.getUserInput().toUpperCase();
            try {
                selectOption(userInput);
            } catch (IllegalArgumentException iae) {
                handleIllegalArgumentException(userInput, iae);
            } catch (NullPointerException npe) {
                handleNullPointerException(npe);
            }
        } while (!"Home".equalsIgnoreCase(userInput));
    }

    private void handleIllegalArgumentException(String illegalArgument, IllegalArgumentException iae) {
        handleException("[ %s ] is an invalid argument.", illegalArgument);
    }

    private void handleNullPointerException(NullPointerException npe) {
        handleException("Unable to retrieve data with input value.");
    }

    private void handleException(String message, Object... args) {
        System.out.printf(message, args);
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("===== %s =====", getClass().getSimpleName());
        System.out.println("Select option:");
        for (Enum e : menuOptions) {
            System.out.printf("[ %s ] ", e.name());
        }
        return scanner.nextLine();
    }
}


