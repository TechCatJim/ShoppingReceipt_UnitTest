package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
//    private boolean isTaxExempt;
    private Map<String, Boolean> taxExemptStatusByLocation;
}
