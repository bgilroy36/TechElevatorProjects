package com.techelevator;

import java.util.ArrayList;
import java.util.List;

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


//        public List<String> getProdList() {return prodList;}

    }


