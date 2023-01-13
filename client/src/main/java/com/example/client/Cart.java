package com.example.client;

import com.example.model.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;

public class Cart {
    @FXML
    private Label brp;

    @FXML
    private Button decrease;

    @FXML
    private Button increase;

    @FXML
    private Label labelcart;
    @FXML
    private Label harga;
    private Menu menu;
    private Listener2 myListener2;
    @FXML
    void CLICK2(MouseEvent mouseEvent){
        myListener2.clicedcart(menu);
    }

    public void setData(Menu menu, Listener myListener, Listener2 myListener2){
        this.menu = menu;
        this.myListener2 = myListener2;



        labelcart.setText(menu.getName());




        DecimalFormat formatter = new DecimalFormat("#,###.000 ");
        harga.setText(main.CURRENCY + formatter.format(menu.getPrice()));



    }
}
