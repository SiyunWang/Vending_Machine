package com.company;
import java.util.Arrays;
public class VendingMachine {
    Item snickers = new Item("snickers", 1.5, 100);
    Item chips = new Item("chips", 1.25, 100);
    Item coke = new Item("coke", 1.75, 100);
    Item cheezits = new Item("cheezits", 0.75, 100);
    Item popCorn = new Item("popCorn", 1.5, 100);
    public Item[] vendingItems = new Item[]{snickers, chips, coke, cheezits, popCorn};
    private double totalMoney = 100;
    private double currentBalance = 0;
    private int[] pendingQuantities = new int[vendingItems.length];
    Calculator ourCalculator = new Calculator();
    public double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(double total) {
        this.totalMoney = total;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    public void displayItems() {
        System.out.println("the items available are: ");
        for (int i = 0; i < vendingItems.length; i++) {
            System.out.println("Code: " + (i + 1) + " Item: " + vendingItems[i].getItemName() + " price: " + vendingItems[i].getPrice());
        }
        System.out.println("Would you like to purchase anything?y/n");
        String purchase = Main.scanner.nextLine();
        if (purchase.equals("y")) {
            selectItems();
        } else {
            System.out.println("Have a great day!");
        }
    }
    public void selectItems() {
        boolean isSelecting = true;
        while (isSelecting) {
            System.out.println("Enter the code for desired item: ");
            int itemCode = Main.scanner.nextInt();
            Main.scanner.nextLine();
            System.out.println("Enter the number of " + vendingItems[itemCode - 1].getItemName() + " you want: ");
            int quantity = Main.scanner.nextInt();
            Main.scanner.nextLine();
            if (quantity + pendingQuantities[itemCode - 1] > vendingItems[itemCode - 1].getNumOfItemsAvailable()) {
                System.out.println("sorry only have " + vendingItems[itemCode - 1].getNumOfItemsAvailable() + " available.");
            } else {
                pendingQuantities[itemCode - 1] += quantity;
                addsBalance(vendingItems[itemCode - 1].getPrice() * quantity);
            }
//            System.out.println("pending: " + Arrays.toString(pendingQuantities));
            System.out.println("current balance is " + getCurrentBalance());
            System.out.println("Would you like anything else? y/n");
            String continueSelecting = Main.scanner.nextLine();
            if (!continueSelecting.equals("y")) {
                isSelecting = false;
            }
        }
        checkout();
    }
    public void checkout() {
        double curBal = getCurrentBalance();
        System.out.println("Here are the items you ordered: ");
        for (int i = 0; i < pendingQuantities.length; i++) {
            if (pendingQuantities[i] > 0) {
                System.out.println(pendingQuantities[i] + " " + vendingItems[i].getItemName());
            }
        }
        System.out.println("Your final cost is: " + curBal + " Please enter the amount of money you want to pay");
        double amountPaid = Main.scanner.nextDouble();
        double change = amountPaid - curBal;
        if (amountPaid >= curBal) {
            setTotalMoney(getTotalMoney() + curBal);
            System.out.println("Thanks for shopping with us! Here is your change: " + change);
        } else {
            System.out.println("Purchase failed, not enough funds. Here is your " + amountPaid + " back.");
        }
    }
    private double addsBalance(double a) {
        double prevBalance = getCurrentBalance();
        setCurrentBalance(prevBalance + a);
        return prevBalance + a;
    }
}