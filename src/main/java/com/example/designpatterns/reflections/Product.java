package com.example.designpatterns.reflections;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Product extends ProductBase {

    private String productName;

    private String category;

    private Double price;

    private List<String> parts = new ArrayList<String>();

    public Double discount(Double ratio) {

        return price * 100 / ratio;
    }
}
