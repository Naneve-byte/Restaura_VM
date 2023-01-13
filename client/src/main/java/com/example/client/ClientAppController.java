package com.example.client;

import com.example.model.Menu;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        menu.setPrice(40.000);
        menu.setImg("/images/ramen-shio.JPG");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Ramen Spicy Tantan");
        menu.setPrice(40.0000);
        menu.setImg("/images/Ramen-tan-tan.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Ramen Special Bowl");
        menu.setPrice(48.0000);
        menu.setImg("/images/Ramen-Special-Bowl.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Bakmie Special Pedas Komplit");
        menu.setPrice(50.0000);
        menu.setImg("/images/Bakmie-Special-Pedas-Komplit.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("Bakmie Special Asin Komplit");
        menu.setPrice(45.000);
        menu.setImg("/images/Bakmie-Special-Asin-Komplit.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Oyako Don");
        menu.setPrice(38.0000);
        menu.setImg("/images/Oyako-Don.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Teriyaki Don");
        menu.setPrice(38.0000);
        menu.setImg("/images/Teriyaki-Don.jpeg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Dakgabli + nasi");
        menu.setPrice(38.0000);
        menu.setImg("/images/dakgalbi+rice.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Buldak + Nasi");
        menu.setPrice(38.0000);
        menu.setImg("/images/Buldak+Nasi.jpg");
        menus.add(menu);



        menu = new Menu();
        menu.setName("Ayam Panggang 1 porsi");
        menu.setPrice(30.0000);
        menu.setImg("/images/Ayam-panggang-1-porsi.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Sparkling Lime");
        menu.setPrice(20.0000);
        menu.setImg("/images/Sparkling-Lime.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Teh botol Sosro");
        menu.setPrice(10.0000);
        menu.setImg("/images/Teh_Botol_Sosro.jpg");
        menus.add(menu);


        menu = new Menu();
        menu.setName("Air mineral");
        menu.setPrice(8.0000);
        menu.setImg("/images/lemineral.jpg");
        menus.add(menu);

        menu = new Menu();
        menu.setName("Extra Sambal Special");
        menu.setPrice(7.0000);
        menu.setImg("/images/samabal.jpg");
        menus.add(menu);





        return menus;
    }
    private void setChosen(Menu menu) {
        gNameLable.setText(menu.getName());
        gPriceLabel.setText(main.CURRENCY + menu.getPrice());
        image = new Image(getClass().getResourceAsStream(menu.getImg()));
        gImg.setImage(image);
        gImg.setFitWidth(200);
        gImg.setFitHeight(200);
        gImg.setPreserveRatio(true);
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
        int column = 0;
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
