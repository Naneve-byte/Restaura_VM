package com.example.model;

import com.example.client.ClientAppitemController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class cartpem {
/*    private static cartpem INSTANCE;
    public  static cartpem getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new cartpem();
        }
        return INSTANCE;
    }

  private Map<String, CartEntry> entries;
  public  cartpem() {
        this.entries = new HashMap<>();
    }
    public void addProduct(String productName){
        CartEntry producEntry = entries.get(productName.toUpperCase());
        CartEntry ada= entries.get();
        if(producEntry != null){
            producEntry.increaseQuantity();
        }else{
            Menu menuss = Menu.valueOf(productName);
            CartEntry entry = new CartEntry(menuss,1);
            entries.put(productName.toUpperCase(),entry);
        }
    }
    public void removeProduct(String productName){
        CartEntry productEntry = new CartEntry.get(productName.toUpperCase());
        if (productEntry!=null) {
            productEntry.decreaseQuantity();
        }
    }
    public int getQuantity(String productName){
      CartEntry entry =entries.get(productName.toUpperCase());
      if (entry!=null){
          return entry.getQuantity();
      }
      return 0;
    }
    public double calculateTotal(){
        double total = 0;
        for(CartEntry entry : entries.values()) {
            double entryCost = entry.getProduct().getPrice()*entry.getQuantity;
            total=total + entryCost;
        }
        return total;
    }*/
}
