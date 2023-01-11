package com.example.client;

import com.example.model.Menu;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClientAppController<MFXButton> implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane opacityPane;
    @FXML
    private VBox chosen;
    @FXML
    private ImageView gImg;

    @FXML
    private Label gNameLable;

    @FXML
    private Label gPriceLabel;

    private Image image;
    private Listener myListener;
    @FXML
    private MFXButton cartclick;

    @FXML
    private Label cartclick2;
    @FXML
    private Label cartclick21;





    private List<Menu> menus = new ArrayList<>();


    private List<Menu> getData() {
        List<Menu> menus = new ArrayList<>();
        Menu menu;

        menu = new Menu();
        menu.setName("Ramen Shio");
        menu.setPrice(3.99);
        menu.setImg("/images/Shio-Ramen-9487-II.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Ramen Spicy Tantan");
        menu.setPrice(3.99);
        menu.setImg("/images/tan-tan-noodles-17-scaled.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/lemineral.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/lemineral.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Ramen Shio");
        menu.setPrice(3.99);
        menu.setImg("/images/Shio-Ramen-9487-II.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Ramen Spicy Tantan");
        menu.setPrice(3.99);
        menu.setImg("/images/tan-tan-noodles-17-scaled.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/lemineral.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/lemineral.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("adw");
        menu.setPrice(3.99);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);







        return menus;
    }
    private void setChosen(Menu menu) {
        gNameLable.setText(menu.getName());
        gPriceLabel.setText(main.CURRENCY + menu.getPrice());
        image = new Image(getClass().getResourceAsStream(menu.getImg()));
        gImg.setImage(image);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        opacityPane.setTranslateX(700);
        cartclick21.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(opacityPane);

            slide.setToX(0);
            slide.play();

            opacityPane.setTranslateX(500);

            slide.setOnFinished((ActionEvent e)-> {
                cartclick21.setVisible(false);
                cartclick2.setVisible(true);
            });
        });
        cartclick2.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(opacityPane);

            slide.setToX(700);
            slide.play();

            opacityPane.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                cartclick21.setVisible(true);
                cartclick2.setVisible(false);
            });
        });

        menus.addAll(getData());
        if(menus.size()>0){
            setChosen(menus.get(0));
            myListener = new Listener() {
                @Override
                public void onClickListener(Menu menu) {
                    setChosen(menu);
                }
            };

        }
        int column = 3;
        int row = 1;

        try {
            for (int i = 0; i < menus.size(); i++) {
                FXMLLoader fxmlloadl = new FXMLLoader();
                fxmlloadl.setLocation(getClass().getResource("Clientitem.fxml"));

                AnchorPane anchorPane = fxmlloadl.load();
                ClientAppitemController clientAppitemController = fxmlloadl.getController();
                clientAppitemController.setData(menus.get(i),myListener);

                if (column == 3) {
                    column=0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MFXButton getCartclick() {
        return cartclick;
    }

    public void setCartclick(MFXButton cartclick) {
        this.cartclick = cartclick;
    }
}
