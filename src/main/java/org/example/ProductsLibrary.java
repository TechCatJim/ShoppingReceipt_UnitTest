package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProductsLibrary {
    private Map<String, Product> products;

    public ProductsLibrary() {
        products = new HashMap<>();
//        products.put("book", new Product("book", 17.99, false));
//        products.put("potato chips", new Product("potato chips", 3.99, true));
//        products.put("pencil", new Product("pencil", 2.99, false));
//        products.put("shirt", new Product("shirt", 29.99, true));


        Map<String, Boolean> bookTaxExemptStatusByLocation = new HashMap<>();
        bookTaxExemptStatusByLocation.put("CA", false);
        bookTaxExemptStatusByLocation.put("NY", false);
        products.put("book", new Product("book", 17.99, bookTaxExemptStatusByLocation));

        Map<String, Boolean> potatoChipsTaxExemptStatusByLocation = new HashMap<>();
        potatoChipsTaxExemptStatusByLocation.put("CA", true);
        potatoChipsTaxExemptStatusByLocation.put("NY", true);
        products.put("potato chips", new Product("potato chips", 3.99, potatoChipsTaxExemptStatusByLocation));

        Map<String, Boolean> pencilTaxExemptStatusByLocation = new HashMap<>();
        pencilTaxExemptStatusByLocation.put("CA", false);
        pencilTaxExemptStatusByLocation.put("NY", false);
        products.put("pencil", new Product("pencil", 2.99, pencilTaxExemptStatusByLocation));

        Map<String, Boolean> shirtTaxExemptStatusByLocation = new HashMap<>();
        shirtTaxExemptStatusByLocation.put("CA", false);
        shirtTaxExemptStatusByLocation.put("NY", true);
        products.put("shirt", new Product("shirt", 29.99, shirtTaxExemptStatusByLocation));
    }

    public Product getProduct(String name) {
        return products.get(name);
    }
}
