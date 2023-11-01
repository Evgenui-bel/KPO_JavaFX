package com.example.kpo_javafx.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public  class EntityOrdersHistory {
    private List <EntitySalad> orderHistory = new ArrayList<>();

    public EntityOrdersHistory() {
    }

    public List<EntitySalad> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<EntitySalad> orderHistory) {
        this.orderHistory = orderHistory;
    }

}
