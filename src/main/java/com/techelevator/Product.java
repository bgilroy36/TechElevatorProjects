package com.techelevator;

public class Product {

    private String name;
    private int price;
    private String type;
    private String slot;


        public Product(String name, int price, String type, String slot) {
            this.name = name;
            this.price = price;
            this.type = type;
            this.slot = slot;
        }

        public String getName(){
            return name;
        }

        public int getprice(){
            return price;
        }

        public String getType(){
            return type;
        }

        public String getSlot(){
            return slot;
            }


    }


