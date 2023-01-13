package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class CartEntry {

    private double totalCost;
    private String name;
    private String img;
    private double price;
    private Menu menuss;
    private int quantity;


    public Menu getMenus() {
        return menuss;
    }

    public int getQuantity() {
        return quantity;
    }


    public CartEntry(Menu menuss, int quantity) {
        this.menuss = menuss;
        this.quantity = quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }
    public void decreaseQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }
}
