package com.company;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // display the items available with code to select the item
        // while selecting items
        // user pick desired item
        // user will pick quantity
        // display the running total
        // Ask to add more
        // break when user finished
        // Calculate/ print the total price
        // have user pay
        // return their change
        VendingMachine ourVendingMachine = new VendingMachine();
        ourVendingMachine.displayItems();
    }
}
