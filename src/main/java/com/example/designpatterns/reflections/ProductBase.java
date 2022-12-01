package com.example.designpatterns.reflections;

import lombok.Data;

@Data
public class ProductBase {

    private Long id;

    public ProductBase(){

    }

    public ProductBase(Long id) {
        this.id = id;
    }

}
