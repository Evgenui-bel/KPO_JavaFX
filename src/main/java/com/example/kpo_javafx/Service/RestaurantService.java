package com.example.kpo_javafx.Service;

import com.example.kpo_javafx.Entity.EntityOrdersHistory;
import com.example.kpo_javafx.Entity.EntitySalad;


public class RestaurantService {

    public static int totalPrice(EntityOrdersHistory order){
        int price = 0;
        for (EntitySalad entity : order.getOrderHistory()) {
            price += entity.getPrice();
        }
        return price;
    }
}
