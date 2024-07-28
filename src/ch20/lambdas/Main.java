package gr.aueb.cf.ch20.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    private static final List<Product> products = Arrays.asList(new Product(1, "Milk", 2.60, 20),
            new Product(2, "Honey", 8.20, 15),
            new Product(3, "Apples", 3.0, 50),
            new Product(4, "Oranges", 2.24, 24),
            new Product(5, "Ice Cream", 5.50, 16));

    public static void main(String[] args) {

        List<Product> filteredProducts = getFilteredProducts(products, product -> product.getId() > 2);
        printProducts(filteredProducts, System.out::println);
        printProducts(filteredProducts, Product::printProduct);

        System.out.println();

        filteredProducts = getFilteredProducts(products, product ->  product.getPrice() > 2.30 && product.getPrice() < 5.0);
        printProducts(filteredProducts, System.out::println);
        printProducts(filteredProducts, Product::printProduct);

        System.out.println();

        filteredProducts = getFilteredProducts(products, product -> product.getQuantity() >= 20);
        printProducts(filteredProducts, System.out::println);
        printProducts(filteredProducts, Product::printProduct);
    }

    public static List<Product> getFilteredProducts(List<Product> products, Predicate<Product> filter) {
        List<Product> productsToReturn = new ArrayList<>();
        for (Product product : products) {
            if (filter.test(product)) {
                productsToReturn.add(product);
            }
        }
        return productsToReturn;
    }

    public static void printProducts(List<Product> products, Consumer<Product> consumer) {
        for (Product product : products) {
            consumer.accept(product);
            }
        }

}
