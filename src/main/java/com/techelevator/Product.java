package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Product extends Inventory {

    private String name;
    private double price;
    private String type;
    private String slot;
//    private List<String> prodList = new ArrayList<>(); >> don't think we need it


        public Product(String name, double price, String type, String slot) {
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

//        public List<String> getProdList() {return prodList;}

    }


