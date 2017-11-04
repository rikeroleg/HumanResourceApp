package io.zipcoder.threedaystodeliver.humanresourceapp;

import io.zipcoder.threedaystodeliver.humanresourceapp.menus.MainMenu;

public class Main {


    public static void main(String[] args) {
        while (true) {
            MainMenu.INSTANCE.display();
        }
    }
}
