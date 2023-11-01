package com.example.kpo_javafx.Entity;

public class EntitySalad {
    private String name;
    private int calories;
    private int weight;
    private int price;

    public EntitySalad(String name, int calories, int weight, int price) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }
    /*@Override
    public String toString() {
        return "Ваш заказ: { Название позиции = " + this.name + ", Цена = " + this.price + ", Вес порции = " + this.weight + ", Калорийность = " + this.calories + "}";
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

