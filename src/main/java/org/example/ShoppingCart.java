package org.example;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ShoppingCart {
    private String location;
    private Map<Product, Integer> products;

    public ShoppingCart(String location){
        this.location = location;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        this.products.put(product, quantity);
    }

    public void printReceipt() {

        double subtotal = 0.0;
        double tax = 0.0;

        System.out.println(String.format("%-12s %10s %10s", "item", "price", "qty"));
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {

            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice();
            String name = product.getName();

            double totalProductPrice = price * quantity;
            subtotal += totalProductPrice;

            if (!product.getTaxExemptStatusByLocation().get(location)) {
                double salesTaxRate = location.equals("CA") ? 0.0975 : 0.08875;
                //rounded up to the nearest 0.05
                double productTax = Math.ceil(totalProductPrice * salesTaxRate * 20) / 20;
                tax += productTax;
            }
            System.out.println(String.format("%-12s %10s %10d", name, String.format("$%.2f",price), quantity));
        }

        System.out.println(String.format("%-12s %10s %10s", "Subtotal:", "" , String.format("$%.2f", subtotal)));
        System.out.println(String.format("%-12s %10s %10s", "Tax:", "" , String.format("$%.2f", tax)));
        System.out.println(String.format("%-12s %10s %10s", "Total:", "", String.format("$%.2f", subtotal + tax)));
    }
}
