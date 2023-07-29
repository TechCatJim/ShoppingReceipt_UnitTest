import org.example.ProductsLibrary;
import org.example.ShoppingCart;
import org.junit.Test;
import org.example.Product;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    @Test
    public void testAddProduct(){
        ShoppingCart cart = new ShoppingCart("CA");
        ProductsLibrary productsLibrary = new ProductsLibrary();
        Product book = productsLibrary.getProduct("book");
        cart.addProduct(book, 1);
        assertTrue(cart.getProducts().containsKey(book));
        assertEquals((int)cart.getProducts().get(book), 1);
    }

    @Test
    public void testPrintReceipt(){

        // Redirect standard output to a ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ShoppingCart cart = new ShoppingCart("CA");
        ProductsLibrary productsLibrary = new ProductsLibrary();
        Product book = productsLibrary.getProduct("book");
        Product potatochips = productsLibrary.getProduct("potato chips");
        cart.addProduct(book, 1);
        cart.addProduct(potatochips, 1);

        cart.printReceipt();

        String[] lines = outContent.toString().split("\n");
        double subtotal = Double.parseDouble(lines[lines.length - 3].split("\\$")[1]);
        double tax = Double.parseDouble(lines[lines.length - 2].split("\\$")[1]);
        double total = Double.parseDouble(lines[lines.length - 1].split("\\$")[1]);

        assertEquals(21.98, subtotal, 0.01);
        assertEquals(1.80, tax, 0.01);
        assertEquals(23.78, total, 0.01);

        // Reset standard output
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

}
