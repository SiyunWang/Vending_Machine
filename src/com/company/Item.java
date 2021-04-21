package com.company;
public class Item {
    private String itemName;
    private double price;
    private int numOfItemsAvailable;
    public Item(String itemName, double price, int numOfItemsAvailable) {
        this.itemName = itemName;
        this.price = price;
        this.numOfItemsAvailable = numOfItemsAvailable;
    }
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getNumOfItemsAvailable() {
        return numOfItemsAvailable;
    }
    public void setNumOfItemsAvailable(int numOfItemsAvailable) {
        this.numOfItemsAvailable = numOfItemsAvailable;
    }
}