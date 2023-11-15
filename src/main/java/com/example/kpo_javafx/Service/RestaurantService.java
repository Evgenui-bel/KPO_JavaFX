package com.example.kpo_javafx.Service;

import com.example.kpo_javafx.Entity.EntityOrdersHistory;
import com.example.kpo_javafx.Entity.EntitySalad;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RestaurantService {
    final static Logger logger = LogManager.getLogger(RestaurantService.class);

    public static int totalPrice(EntityOrdersHistory order){
        int price = 0;
        for (EntitySalad entity : order.getOrderHistory()) {
            price += entity.getPrice();
            logger.info("The price increased by " + price + "$");
        }
        logger.info("Total price " + price + "$");
        return price;
    }
}
