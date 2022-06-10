package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    private String name;
    private double price;
    private String type;
    private String slot;
//    private List<String> prodList = new ArrayList<>(); >> don't think we need it


        public Product(String slot, String name, double price, String type) {
            this.name = name;
            this.price = price;
            this.type = type;
            this.slot = slot;
        }


        public String getName(){
            return name;
        }

        public double getPrice(){
            return price;
        }

        public String getType(){
            return type;
        }

        public String getSlot(){
            return slot;
            }

            public String itemSound() {
                if (getType().equalsIgnoreCase("Chip")) {
                    return ("Crunch Crunch, Yum!");
                }
                if (getType().equalsIgnoreCase("Candy")) {
                    return ("Munch Munch, Yum!");
                }
                if (getType().equalsIgnoreCase("Drink")) {
                    return ("Glug Glug, Yum!");

                }
                if (getType().equalsIgnoreCase("Gum")) {
                    return ("Chew Chew, Yum!");
                }

                return "";
            }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(type, product.type) && Objects.equals(slot, product.slot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type, slot);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", slot='" + slot + '\'' +
                '}';
    }

    //        public List<String> getProdList() {return prodList;}

    }


