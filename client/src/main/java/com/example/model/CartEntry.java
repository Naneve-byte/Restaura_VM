package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class CartEntry {
    private List<Menu> menus =new ArrayList<>();
    private Menu product;
    private double totalCost;

    private int quantity;
    double price;

    public ShoppingCart() {
        menus = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public double getTotalCost() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }


   /* public CartEntry() {
        this.menus = new ArrayList<>();
        this.totalCost = 0;
    }



    public Menu getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void increaseQuantity(){
        this.quantity++;
    }
    public void decreaseQuantity(){
        if(this.quantity>0){
            this.quantity--;
        }
    }*/
}
