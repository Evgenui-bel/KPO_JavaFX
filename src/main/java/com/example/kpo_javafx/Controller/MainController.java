package com.example.kpo_javafx.Controller;

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

import java.io.IOException;

public class MainController {
    static EntityOrdersHistory order = new EntityOrdersHistory();

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
        AddOlivieButton.setOnAction(event -> {order.getOrderHistory().add(new EntitySalad("Оливье", 800, 200, 15));});
        AddVinegretButton.setOnAction(event -> {order.getOrderHistory().add(new EntitySalad("Винегрет", 150, 200, 10));});
        PriceTotalButton.setOnAction(event -> {
            TotalPriceLabel.setText("Cумма к оплате: " + RestaurantService.totalPrice(order) + "$");
            try {
                PriceService.writePrice(RestaurantService.totalPrice(order));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}