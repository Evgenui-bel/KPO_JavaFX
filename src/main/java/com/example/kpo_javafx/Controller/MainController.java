package com.example.kpo_javafx.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.kpo_javafx.Entity.EntityOrdersHistory;
import com.example.kpo_javafx.Entity.EntitySalad;
import com.example.kpo_javafx.HelloApplication;
import com.example.kpo_javafx.Service.PriceService;
import com.example.kpo_javafx.Service.RestaurantService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.*;

public class MainController {
    static EntityOrdersHistory order = new EntityOrdersHistory();

    final static Logger logger = LogManager.getLogger(MainController.class);
    @FXML
    private Button AddCezarButton;

    @FXML
    private Button AddKrabButton;

    @FXML
    private Button AddMimozaButton;

    @FXML
    private Button AddOlivieButton;

    @FXML
    private Button AddVinegretButton;

    @FXML
    private Button PriceTotalButton;
    @FXML
    private Label TotalPriceLabel;

    @FXML
    public void initialize() {
        AddCezarButton.setOnAction(event -> {order.getOrderHistory().add(new EntitySalad("Цезарь", 300, 200, 20));});
        AddKrabButton.setOnAction(event -> {order.getOrderHistory().add(new EntitySalad("Крабовый", 600, 200, 35));});
        AddMimozaButton.setOnAction(event -> {order.getOrderHistory().add(new EntitySalad("Мимоза", 400, 200, 35));});
        //AddOlivieButton.setOnAction(event -> {order.getOrderHistory().add(new EntitySalad("Оливье", 800, 200, 15));});
        AddOlivieButton.setOnAction(event ->{
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Custom_menu.txt"));
                objectOutputStream.writeObject(order);
                objectOutputStream.close();
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Custom_menu.txt"));
                order = (EntityOrdersHistory) objectInputStream.readObject();
                order.getOrderHistory().add(new EntitySalad("Оливье", 800, 200, 15));
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        //AddVinegretButton.setOnAction(event -> {order.getOrderHistory().add(new EntitySalad("Винегрет", 150, 200, 10));});
        AddVinegretButton.setOnAction(event -> {
            try {
                EntitySalad.serialisation(new EntitySalad("Винегрет",150,200,10));
                order.getOrderHistory().add(EntitySalad.deserealisation());
            } catch (Exception e) {
                System.out.println("Error");
            }
        });
        PriceTotalButton.setOnAction(event -> {
            TotalPriceLabel.setText("Cумма к оплате: " + RestaurantService.totalPrice(order) + "$");
            try {
                logger.info("Function for calling total price calculation");
                PriceService.writePrice(RestaurantService.totalPrice(order));
            } catch (IOException e) {
                logger.error("An error occurred",e);
                throw new RuntimeException(e);
            }
        });
    }
}