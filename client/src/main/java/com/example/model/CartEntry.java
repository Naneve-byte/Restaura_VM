package com.example.model;

public class CartEntry {
    private Menu product;
    private int quantity;

    public CartEntry(Menu product, int quantity) {
        this.product = product;
        this.quantity = quantity;
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
    }
}
