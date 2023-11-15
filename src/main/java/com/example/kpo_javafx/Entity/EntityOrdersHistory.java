package com.example.kpo_javafx.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public  class EntityOrdersHistory implements Externalizable {
    private List <EntitySalad> orderHistory = new ArrayList<>();
    @Serial
    private static final long serialVersionUID = 2L;
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getOrderHistory());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        orderHistory = (List<EntitySalad>) in.readObject();
    }

    public EntityOrdersHistory() {
    }

    public List<EntitySalad> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<EntitySalad> orderHistory) {
        this.orderHistory = orderHistory;
    }

}
