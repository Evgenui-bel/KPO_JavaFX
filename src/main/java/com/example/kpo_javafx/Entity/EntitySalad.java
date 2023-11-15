package com.example.kpo_javafx.Entity;

import java.io.*;

public class EntitySalad implements Serializable  { // интерфейс-маркер
    @Serial
    private static final long serialVersionUID = 1L; // t r a n s i e n t
    private String name;
    private int calories;
    private int weight;
    private int price;
    /*@Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(calories);
        out.writeInt(weight);
        out.writeInt(price);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        calories = in.readInt();
        weight = in.readInt();
        price = in.readInt();
    }*/


    public EntitySalad(String name, int calories, int weight, int price) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.price = price;
    }
    public static void serialisation(EntitySalad salad) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Menu.txt"));
            objectOutputStream.writeObject(salad);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static EntitySalad deserealisation() throws IOException, ClassNotFoundException {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Menu.txt"));
            EntitySalad salad = (EntitySalad) objectInputStream.readObject();
            objectInputStream.close();
            return salad;
    }




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

