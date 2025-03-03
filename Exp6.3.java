import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ", $" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        
        products.add(new Product("Laptop", "Electronics", 1200));
        products.add(new Product("Phone", "Electronics", 800));
        products.add(new Product("T-Shirt", "Clothing", 20));
        products.add(new Product("Jeans", "Clothing", 50));
        products.add(new Product("Sneakers", "Footwear", 100));
        products.add(new Product("Sandals", "Footwear", 100));
        products.add(new Product("Headphones", "Electronics", 300));

        
        System.out.println("Case 1: Normal Case");
        processProducts(products);

        
        System.out.println("\nCase 2: Single Category Only");
        List<Product> electronicsOnly = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800)
        );
        processProducts(electronicsOnly);

        
        System.out.println("\nCase 3: Same Price in a Category");
        List<Product> footwearSamePrice = Arrays.asList(
                new Product("Sneakers", "Footwear", 100),
                new Product("Sandals", "Footwear", 100)
        );
        processProducts(footwearSamePrice);

        
        System.out.println("\nCase 4: Only One Product");
        List<Product> singleProduct = Collections.singletonList(
                new Product("Laptop", "Electronics", 1200)
        );
        processProducts(singleProduct);

        
        System.out.println("\nCase 5: Empty List");
        List<Product> emptyList = new ArrayList<>();
        processProducts(emptyList);
    }

    private static void processProducts(List<Product> products) {
        
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        
        Map<String, Optional<Product>> mostExpensiveByCategory = groupedByCategory.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .max(Comparator.comparingDouble(Product::getPrice))
                ));

        
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        
        System.out.println("Grouped Products by Category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost Expensive Products by Category:");
        mostExpensiveByCategory.forEach((category, product) -> {
            System.out.println(category + ": " + (product.isPresent() ? product.get() : "None"));
        });

        System.out.printf("\nAverage Price of All Products: $%.2f%n", averagePrice);
    }
}
