package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import java.time.LocalDate;
import java.util.Scanner;

public class SanitizeTools
{
    public static LocalDate getEnforcedLocalDateInput(){
        Scanner in = new Scanner(System.in);
        LocalDate localDateInput;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputLocalDate(sInput)) {
                System.out.println("Please enter a date in YYYY-MM-DD format.");
            }
        }while (!isInputLocalDate(sInput));
        localDateInput=LocalDate.parse(sInput);
        return localDateInput;
    }

    private static boolean isInputLocalDate(String passedString)
    {
        try {
            LocalDate output = LocalDate.parse(passedString);
        } catch (Exception e) {
            return false;
        }
        return (true);
    }

    public static double getEnforcedDoubleInput(){
        Scanner in = new Scanner(System.in);
        double dInput;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputDouble(sInput)) {
                System.out.println("Please enter a decimal number.");
            }
        }while (!isInputDouble(sInput));
        dInput=Double.valueOf(sInput);
        return dInput;
    }

    private static boolean isInputDouble(String passedString)
    {
        try {
            Double output = Double.valueOf(passedString);
        } catch (NumberFormatException e) {
            return false;
        }
        return (true);
    }

    public static double getEnforcedIntegerInput(){
        Scanner in = new Scanner(System.in);
        int iInput;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputInt(sInput)) {
                System.out.println("Please enter an integer number.");
            }
        }while (!isInputInt(sInput));
        iInput=Integer.valueOf(sInput);
        return iInput;
    }

    private static boolean isInputInt(String passedString)
    {
        try {
            Integer output = Integer.valueOf(passedString);
        } catch (NumberFormatException e) {
            return false;
        }
        return (true);
    }


}
