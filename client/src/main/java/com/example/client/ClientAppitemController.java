package com.example.client;

import com.example.model.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class ClientAppitemController  {

    @FXML
    private Label PRICELabel;

    @FXML
    private ImageView imgmenu;

    @FXML
    private Label nameLabel;
    private Menu menu;
    @FXML
    void CLICK(MouseEvent mouseEvent) {
        myListener.onClickListener(menu);

    }
    private Listener myListener;

    public void setData(Menu menu,Listener myListener){
        this.menu = menu;
        this.myListener =myListener;
        nameLabel.setText(menu.getName());
        PRICELabel.setText(main.CURRENCY + menu.getPrice());
        String imageFile = "images/Shio-Ramen-9487-II.jpg";
        //Image image = new Image(getClass().getResourceAsStream(menu.getImg()));
        Image image = new Image(getClass().getResourceAsStream(menu.getImg()));

        imgmenu.setImage(image);

    }
}
